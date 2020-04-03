/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.senac.sp.grupoum.projectpiiv.models.Admin;
import br.senac.sp.grupoum.projectpiiv.models.Estoquista;
import br.senac.sp.grupoum.projectpiiv.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static Usuario buscarEmail(String email) {
        boolean retorno = false;
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT u.Email, u.Senha, f.Tipo FROM "
                    + "usuario u INNER JOIN funcionario f ON f.id_usuario = u.id_usuario WHERE email LIKE ?");
            comando.setString(1, email);
            ResultSet rs = comando.executeQuery();

            Usuario usuario = null;

            while (rs.next()) {
                if (rs.getString("tipo").equals("Admin")) {
                    usuario = new Admin();
                } else if (rs.getString("tipo").equals("Estoquista")) {
                    usuario = new Estoquista();

                }
                
                usuario.setEmail(rs.getString("Email"));
                usuario.setSenha(rs.getString("Senha"));
            }

            DbConnectionDAO.closeConnection(connection);
            return usuario;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
