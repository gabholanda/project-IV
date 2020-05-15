package dao;

import br.senac.sp.grupoum.projectpiiv.models.Endereco;
import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
import br.senac.sp.grupoum.projectpiiv.models.Produto;
import br.senac.sp.grupoum.projectpiiv.models.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
}
