package dao;

import br.senac.sp.grupoum.projectpiiv.models.Endereco;
import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
import br.senac.sp.grupoum.projectpiiv.models.Produto;
import br.senac.sp.grupoum.projectpiiv.models.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author erickgurian
 */
public class VendaDAO {

    public static ArrayList<Venda> vendasPorCliente(int idCliente) {
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();

            PreparedStatement comando = connection.prepareStatement("SELECT * FROM venda WHERE id_cliente = ?");
            comando.setInt(1, idCliente);
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id_venda"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setDataVenda(rs.getDate("data_venda"));
                venda.setIdCliente(rs.getInt("id_cliente"));
                venda.setStatusCompra(rs.getString("status_venda"));
                venda.setMetodoPagamento(rs.getString("metodo_pagamento"));
                vendas.add(venda);
            }

            DbConnectionDAO.closeConnection(connection);
            return vendas;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static Venda pesquisarPorId(int id) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            Venda venda = new Venda();

            PreparedStatement comando = connection.prepareStatement("SELECT * FROM venda WHERE id_venda = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                venda.setId(rs.getInt("id_venda"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setDataVenda(rs.getDate("data_venda"));
                venda.setIdCliente(rs.getInt("id_cliente"));
                venda.setStatusCompra(rs.getString("status_venda"));
                venda.setMetodoPagamento(rs.getString("metodo_pagamento"));
                venda.setValorFrete(rs.getDouble("frete"));
                Endereco endereco = EnderecoDAO.pesquisarPorId(rs.getInt("id_enderecos"));
                venda.setEndereco(endereco);
            }

            comando = connection.prepareStatement("SELECT * FROM item_venda WHERE id_venda = ?");
            comando.setInt(1, id);
            rs = comando.executeQuery();

            while (rs.next()) {
                Produto produto = ProdutoDAO.pesquisarPorId(rs.getInt("id_produto"));
                ItemVenda item = new ItemVenda();
                item.setProduto(produto);
                item.setQuantidade(rs.getInt("quantidade"));

                venda.getItensVenda().add(item);
            }

            DbConnectionDAO.closeConnection(connection);
            return venda;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean finalizarVenda(Venda venda) throws ClassNotFoundException {
        Connection connection = null;
        boolean retorno = false;
        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO venda (valor_total, data_venda, id_cliente, status_venda, metodo_pagamento, frete, id_enderecos) VALUES(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            comando.setDouble(1, venda.getValorTotal());
            comando.setDate(2, Date.valueOf(LocalDate.now()));
            comando.setInt(3, venda.getIdCliente());
            comando.setString(4, "Pagamento Confirmado");
            comando.setString(5, venda.getMetodoPagamento());
            comando.setDouble(6, venda.getValorFrete());
            comando.setInt(7, venda.getEndereco().getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                int id_venda = 0;
                ResultSet resultSet = comando.getGeneratedKeys();

                while (resultSet.next()) {
                    id_venda = resultSet.getInt(1);
                }

                for (int i = 0; i < venda.getItensVenda().size(); i++) {
                    comando = connection.prepareStatement("INSERT INTO item_venda(id_venda, id_produto, quantidade) VALUES(?,?,?)");
                    comando.setInt(1, id_venda);
                    comando.setInt(2, venda.getItensVenda().get(i).getProduto().getId());
                    comando.setDouble(3, venda.getItensVenda().get(i).getQuantidade());
                    linhasAfetadas = comando.executeUpdate();
                }
                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            } else {
                retorno = false;
            }

        } catch (SQLException ex) {
            System.out.println("Aqui PLEAAASE " + ex);
            retorno = false;
        }
        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }
}
