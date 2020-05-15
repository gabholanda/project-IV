package dao;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static boolean salvar(Produto produto, List<File> filesUpload) {
        boolean retorno = false;
        Connection connection = null;
        try {

            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO produto "
                    + "(nome, descricao, tipo_produto, qtd_estoque, preco) "
                    + "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getDescricao());
            comando.setString(3, produto.getTipo());
            comando.setDouble(4, produto.getQuantidade());
            comando.setDouble(5, produto.getPreco());

            int salvar = comando.executeUpdate();

            if (salvar > 0) {
                ResultSet resultSet = comando.getGeneratedKeys();
                int idProduto = 0;

                while (resultSet.next()) {
                    idProduto = resultSet.getInt(1);
                }

                for (File file : filesUpload) {
                    comando = connection.prepareStatement("INSERT INTO imagem_produto (id_produto, caminho_imagem)"
                            + "VALUES(?,?);");
                    comando.setInt(1, idProduto);
                    comando.setString(2, file.getName());
                    int qtd = comando.executeUpdate();

                    if (qtd > 0) {
                        retorno = true;
                    }

                }

                retorno = true;
                DbConnectionDAO.closeConnection(connection);
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            retorno = false;
        }

        return retorno;
    }

    public static ArrayList<Produto> produtosCadastrados() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM produto");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setQuantidade(rs.getDouble("qtd_estoque"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }

            DbConnectionDAO.closeConnection(connection);
            return produtos;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static Produto pesquisarPorId(int id) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Produto produto = new Produto();

            while (rs.next()) {
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setQuantidade(rs.getDouble("qtd_estoque"));
                produto.setPreco(rs.getDouble("preco"));

                comando = connection.prepareStatement("SELECT caminho_imagem FROM imagem_produto WHERE id_produto = ?");
                comando.setInt(1, produto.getId());
                rs = comando.executeQuery();

                while (rs.next()) {
                    produto.getImagens().add(rs.getString("caminho_imagem"));
                }
            }

            DbConnectionDAO.closeConnection(connection);
            return produto;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean editar(Produto produto, List<File> filesUpload) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE loja_esporte.produto "
                    + "SET Nome = ?, tipo_produto = ?, qtd_estoque = ?, preco = ?, "
                    + "descricao = ? WHERE id_produto = ?;", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipo());
            comando.setDouble(3, produto.getQuantidade());
            comando.setDouble(4, produto.getPreco());
            comando.setString(5, produto.getDescricao());
            comando.setInt(6, produto.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet resultSet = comando.getGeneratedKeys();
                


                for (File file : filesUpload) {
                    comando = connection.prepareStatement("INSERT INTO imagem_produto (id_produto, caminho_imagem)"
                            + "VALUES(?,?);");

                    comando.setInt(1, produto.getId());
                    comando.setString(2, file.getName());
                    int qtd = comando.executeUpdate();

                    if (qtd > 0) {
                        retorno = true;
                    }

                }

                retorno = true;
                DbConnectionDAO.closeConnection(connection);
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            retorno = false;

        }
        return retorno;
    }

    public static boolean excluir(int id) throws SQLException {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM produto "
                    + "WHERE id_produto = ?");
            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;

    }
    
     public static boolean atualizarQtd(Produto produto){
         Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE produto "
                    + "SET qtd_estoque = ?"
                    + "WHERE id_produto = ?");

          
            comando.setDouble(1, produto.getQuantidade());
            comando.setInt(2, produto.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;

        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;
     }
     
      public static ArrayList<Produto> produtosCadastradosI() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM produto");
 
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setQuantidade(rs.getDouble("qtd_estoque"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
                
                
            }

            DbConnectionDAO.closeConnection(connection);
            return produtos;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
