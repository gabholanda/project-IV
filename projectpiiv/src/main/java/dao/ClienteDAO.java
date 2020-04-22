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

/**
 *
 * @author Pablo de Oliveira
 */
public class ClienteDAO {

    public static boolean salvar(Cliente c) {

        boolean retorno = false;
        Connection connection = null;

        try {

            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO cliente "
                    + "(nome, sobrenome, cpf, endereco, cep, email, senha) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");
            comando.setString(1, c.getNome());
            comando.setString(2, c.getSobreNome());
            comando.setString(3, c.getCpf());
            comando.setString(4, c.getEndereco());
            comando.setString(5, c.getCep());
            comando.setString(6, c.getEmail());
            comando.setString(7, c.getSenha());

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

            int buscar = comando.executeUpdate();

            DbConnectionDAO.closeConnection(connection);

            if (buscar != 1) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

    public static boolean buscarCpf(String cpf) throws ClassNotFoundException {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM cliente WHERE cpf = ?", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, cpf);

            int buscar = comando.executeUpdate();

            DbConnectionDAO.closeConnection(connection);

            if (buscar != 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return false;

    }

}
