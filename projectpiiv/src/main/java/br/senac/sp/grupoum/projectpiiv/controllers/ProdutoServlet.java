package br.senac.sp.grupoum.projectpiiv.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
 
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import dao.ProdutoDAO;



@WebServlet(name = "ProdutoServlet", urlPatterns = {"/cadastrar-produto"})

public class ProdutoServlet extends HttpServlet {

	
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
   		 	dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	/*Identifica se o formulario é do tipo multipart/form-data*/
        if (ServletFileUpload.isMultipartContent(request)) {
            try {request.setCharacterEncoding("UTF-8");
    		
    		String nome = request.getParameter("nome");
    		String descricao = request.getParameter("descricao");
    		String tipo = request.getParameter("tipo");
    		double preco = Double.valueOf(request.getParameter("preco"));
    		double quantidade = Double.valueOf(request.getParameter("quantidade"));
    		
    		
    		
    		Produto produto = new Produto(nome, descricao, tipo, preco, quantidade);
            	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
                List<FileItem> multiparts = sf.parseRequest(request);
 
                /*Escreve a o arquivo na pasta img*/
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                    	
                        item.write(new File( request.getServletContext().getRealPath("img")+ File.separator + "uploadfile"));
                    }
                }
                ProdutoDAO salvarProduto = new ProdutoDAO();
                boolean salvar = salvarProduto.salvar(produto, multiparts);
	    		if(salvar) {
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
	    			
	       		 	dispatcher.forward(request, response);
	    		}
 
                request.setAttribute("message", "Arquivo carregado com sucesso");
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
            }
 
        } else {
            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
        }
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
		 	dispatcher.forward(request, response);
    }
}
