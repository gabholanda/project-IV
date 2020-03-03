package dao;


import br.senac.sp.grupoum.projectpiiv.models.Produto;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ProdutoDAO {
	
	
	 public boolean salvar(Produto produto, List<FileItem> filesUpload) {
	       
	        Connection connection = null;
	        boolean retorno = false;

	        try {
	        	
	        	 connection = DbConnectionDAO.openConnection();
	             PreparedStatement comando = connection.prepareStatement("INSERT INTO Produto "
	                     + "(Nome, Descricao, TipoProduto, QntEstoque, Preco) "
	                     + "VALUES (?, ?, ?, ?, ?);");
	             comando.setString(1, produto.getNome());
	             comando.setString(2, produto.getDescricao());
	             comando.setString(3, produto.getTipo());
	             comando.setDouble(4, produto.getQuantidade());
	             comando.setDouble(5, produto.getPreco());
	             
	             int salvar = comando.executeUpdate();
	             
	             
	             if(salvar >1) {
	            	 ResultSet resultSet = comando.getGeneratedKeys();
	            	 int idProduto = 0;
	            	 
	            	 while (resultSet.next()) {
	            		 idProduto = resultSet.getInt(1);
	                    }
	            	 
	            	 for (FileItem file : filesUpload) {
	            		 
	            		 comando = connection.prepareStatement("INSERT INTO imagem_produto (IdProduto, caminho_imagem)"
	            		 		+ "VALUES(?,?);");
	            		 comando.setInt(1, idProduto);
	            		 comando.setString(2, file.getName());
	            		 int qtd  = comando.executeUpdate();
	            		 
	            		 if(qtd >0) {
	            			 return true;
	            		 }
	            		 else {
	            			 return false;
	            		 }
	            	 }
	            	 
	            	 return true;
	             }else {
	            	return false;
	             }
	             
	             
	             
	        } catch (Exception ex) {
	            retorno = false;
	        }

	        DbConnectionDAO.closeConnection(connection);
	        return retorno;
	    }
}
