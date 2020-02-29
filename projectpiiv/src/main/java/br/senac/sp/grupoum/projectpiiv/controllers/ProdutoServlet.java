package br.senac.sp.grupoum.projectpiiv.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	
    	try {
    		request.setCharacterEncoding("UTF-8");
    		
    		String nome = request.getParameter("nome");
    		String descricao = request.getParameter("descricao");
    		String tipo = request.getParameter("tipo");
    		double preco = Double.valueOf(request.getParameter("preco"));
    		double quantidade = Double.valueOf(request.getParameter("quantidade"));
    		
    		Produto produto = new Produto(nome, descricao, tipo, preco, quantidade);
    		
    		ProdutoDAO salvarProduto = new ProdutoDAO();
    		
    		boolean salvar = salvarProduto.salvar(produto);
    		if(salvar) {
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
       		 	dispatcher.forward(request, response);
    		}
    		
    		
    	}catch(Exception e) {
    		
    	}
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
