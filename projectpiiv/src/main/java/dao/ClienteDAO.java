/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClienteDAO {

    public static boolean salvar(Cliente c) {

        boolean retorno = false;
        Connection connection = null;

        try {

            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO cliente "
                    + "(nome, sobrenome, cpf, email, senha) "
                    + "VALUES (?, ?, ?, ?, ?);");
            
            comando.setString(1, c.getNome());
            comando.setString(2, c.getSobreNome());
            comando.setString(3, c.getCpf());
            comando.setString(4, c.getEmail());
            comando.setString(5, c.getSenha());

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

    public static boolean buscarEmail(String email) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM cliente WHERE email = ?", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, email);
            
            ResultSet rs = comando.executeQuery();

            int cont = 0;
            
            while (rs.next()) {
                cont++;
            }

            if (cont == 0) {
                DbConnectionDAO.closeConnection(connection);
                return false;
            } else {
                DbConnectionDAO.closeConnection(connection);
                return true;
            }

        } catch (ClassNotFoundException ex) {
            DbConnectionDAO.closeConnection(connection);
            return false;
        } catch (SQLException ex) {
            DbConnectionDAO.closeConnection(connection);
            System.out.println(ex);
            return false;
        }

    }
    
    /*  public static boolean validacaoNome(String nome, String sobreNome) {
        int contarLetra = 0;
        int contarPalavra = 0;
        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);
            if (contarPalavra >= 2) {
                return true;
            } else if (letra != ' ') {
                contarLetra++;
            } else if (contarLetra < 3) {
                return false;
            } else {
                contarPalavra++;
                contarLetra = 0;
            }
        }
        return true;
    }
*/
    public static boolean buscarCpf(String cpf) throws ClassNotFoundException {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM cliente WHERE cpf = ?", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, cpf);

            ResultSet rs = comando.executeQuery();
            
            int cont = 0;
            
            while (rs.next()) {
                cont++;
            }

            if (cont == 0) {
                DbConnectionDAO.closeConnection(connection);
                return false;
            } else {
                DbConnectionDAO.closeConnection(connection);
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static Cliente autenticar(String usuario, String senha) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM cliente"
                    + " WHERE email = ? and senha = ?;");
            comando.setString(1, usuario);
            comando.setString(2, senha);

            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                rs.beforeFirst();
                while (rs.next()) {
                    cliente.setNome(rs.getString("nome"));
                    cliente.setSobreNome(rs.getString("sobrenome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setSenha(rs.getString("Senha"));
                }
                DbConnectionDAO.closeConnection(connection);

                return cliente;
            } else {
                return null;
            }

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public static boolean editar(Cliente cliente) {
        boolean retorno = false;
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(" UPDATE cliente"
                    + " SET nome = ? ,"
                    + " sobrenome = ? ,"
                    + " WHERE cpf = ? ", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getSobreNome());
            comando.setString(3, cliente.getCpf());

            int linhasAfetadas = comando.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }
    

}
