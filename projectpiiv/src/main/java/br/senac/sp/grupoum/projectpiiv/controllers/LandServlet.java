/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo de Oliveira
 */
    @WebServlet(name = "LandServlet", urlPatterns = {"/land"})
public class LandServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/land.jsp");
        dispatcher.forward(request, response);
        
        
        ArrayList<Produto> produtos = ProdutoDAO.produtosCadastrados();
        ArrayList<Produto> produtosI = new ArrayList<>();
        for(int i = 0; i <= produtos.size(); i++){
            Produto produto = ProdutoDAO.pesquisarPorId(produtos.get(i).getId());
            
            produtosI.add(produto);
        }
         try {
            if (produtos != null) {
                request.setAttribute("produtoAttr", produtosI);
            }  } catch (Exception ex) {
            System.out.println(ex);
        }
          dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
}

