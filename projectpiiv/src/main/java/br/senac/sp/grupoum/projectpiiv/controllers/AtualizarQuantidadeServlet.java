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
@WebServlet(name = "EditarQuantidadeServlet", urlPatterns = {"/estoquista/atualizar-quantidade"})
public class AtualizarQuantidadeServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atualizar-quantidade.jsp");
        Produto produto = ProdutoDAO.pesquisarPorId(id);

        try {
            if (produto != null) {
                request.setAttribute("idAttr", id);
                request.setAttribute("nomeAttr", produto.getNome());
                request.setAttribute("qtdAttr", produto.getQuantidade());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        double quantidade = Double.parseDouble(request.getParameter("quantidade"));

        Produto produto = new Produto(id, quantidade);

        boolean editou = ProdutoDAO.atualizarQtd(produto);

        if (editou) {
            request.setAttribute("editadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/estoquista.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atualizar-quantidade.jsp");
            dispatcher.forward(request, response);
            
        }

    }

}