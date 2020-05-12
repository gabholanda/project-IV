/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/carrinho"})
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          HttpSession sessao = request.getSession();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        if (sessao.getAttribute("clienteAttr") == null && request.getParameter("id")!= null) {
            int idCliente = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = cDao.pesquisarPorId(idCliente);
            sessao.setAttribute("clienteAttr", cliente);
        }

        List<Produto> produtos = pDao.pesquisarProdutos(idFilial);
        try {
            if (produtos != null) {
                request.setAttribute("produtosAttr", produtos);
                request.getRequestDispatcher("/WEB-INF/realizar-venda.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }   
        
        
    }

}
