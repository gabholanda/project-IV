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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "LandDetalheProdutoServlet", urlPatterns = {"/land/detalhe-produto"})
public class LandDetalheProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         HttpSession sessao = request.getSession();
        if(sessao.getAttribute("usuario") !=null){
            request.setAttribute("LogadoAttr", true);
            request.setAttribute("nLogadoAttr", false);
        }else{
             request.setAttribute("LogadoAttr", false);
             request.setAttribute("nLogadoAttr", true);
        }
        
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/land-produto-detalhe.jsp");
        Produto produto = ProdutoDAO.pesquisarPorId(id);

        try {
            request.setAttribute("produtosAttr", produto);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
