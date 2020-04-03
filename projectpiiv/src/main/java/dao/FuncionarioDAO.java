/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class FuncionarioDAO {

    public static boolean salvar(Funcionario f) {

        boolean retorno = false;
        Connection connection = null;

        try {

            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO funcionario "
                    + "(Nome, Tipo) "
                    + "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, f.getNome());
            comando.setString(2, f.getClass().getSimpleName());
            

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

}
