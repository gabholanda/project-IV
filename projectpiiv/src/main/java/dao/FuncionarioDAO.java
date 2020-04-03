/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.senac.sp.grupoum.projectpiiv.models.Admin;
import br.senac.sp.grupoum.projectpiiv.models.Estoquista;
import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAO {

    public static boolean salvar(Funcionario f) {

        boolean retorno = false;
        Connection connection = null;

        try {

            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO funcionario "
                    + "(Nome, Tipo, status) "
                    + "VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, f.getNome());
            comando.setString(2, f.getTipo());
            comando.setBoolean(3, f.isStatus());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                int id_usuario = 0;
                ResultSet resultSet = comando.getGeneratedKeys();

                while (resultSet.next()) {
                    id_usuario = resultSet.getInt(1);
                }

                comando = connection.prepareStatement("INSERT INTO usuario "
                        + "(id_usuario, Email, Senha) VALUES (?, ?, ?);");
                comando.setInt(1, id_usuario);
                comando.setString(2, f.getEmail());
                comando.setString(3, f.getSenha());

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
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

    public static ArrayList<Funcionario> usuariosCadastrados() {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT id_usuario, Nome, Tipo FROM funcionario WHERE status = 0");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdUser(rs.getInt("id_usuario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionarios.add(funcionario);

            }

            DbConnectionDAO.closeConnection(connection);
            return funcionarios;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Funcionario pesquisarFuncionarioId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM funcionario WHERE id_usuario = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Funcionario funcionario = new Funcionario();

            DbConnectionDAO.closeConnection(connection);
            return funcionario;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean editar(Funcionario f) {
        Connection connection = null;
        boolean retorno = false;

        Funcionario funcionario = (f);

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE funcionario "
                    + "SET Nome = ?, Tipo = ?, status = ?"
                    + "WHERE id_usuario = ?", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, funcionario.getNome());
            comando.setInt(2, funcionario.getIdUser());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {

                comando = connection.prepareStatement("UPDATE usuario SET "
                        + " Senha = ? "
                        + "WHERE id_usuario = ?");

                comando.setString(1, funcionario.getSenha());
                comando.setInt(2, funcionario.getIdUser());

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
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

    public static boolean excluir(int id) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE funcionario SET status = 1"
                    + "WHERE funcionario.id_usuario = ?");
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

    public static Funcionario pesquisaId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT f.id_usuario, f.Nome, f.Tipo, " + ""
                    + "f.status, u.Email, u.Senha "
                    + "FROM funcionario f INNER JOIN usuario u ON f.id_usuario = u.id_usuario WHERE f.id_usuario = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Funcionario funcionario = null;

            while (rs.next()) {
                if (rs.getString("tipo").equals("Admin")) {
                    funcionario = new Admin();
                } else {
                    funcionario = new Estoquista();
                }

                funcionario.setIdUser(rs.getInt("IdFuncionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setTipo(rs.getString("Tipo"));
                funcionario.setStatus(rs.getBoolean("Status"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setSenha(rs.getString("Senha"));
            }

            DbConnectionDAO.closeConnection(connection);
            return funcionario;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
