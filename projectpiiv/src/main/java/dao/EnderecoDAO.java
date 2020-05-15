/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.models.Endereco;
import br.senac.sp.grupoum.projectpiiv.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erickgurian
 */
public class EnderecoDAO {
    
    public static Endereco pesquisarPorId(int id) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM enderecos WHERE id_enderecos = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Endereco endereco = new Endereco();

            while (rs.next()) {
                endereco.setId(rs.getInt("id_enderecos"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setTipo(rs.getString("tipo"));
                
                
                Cliente cliente = ClienteDAO.pesquisarPorId(rs.getInt("id_cliente"));
                endereco.setCliente(cliente);

                
            }

            DbConnectionDAO.closeConnection(connection);
            return endereco;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
}
