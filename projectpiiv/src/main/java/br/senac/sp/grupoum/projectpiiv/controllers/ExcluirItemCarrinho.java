/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablo.santana
 */
@WebServlet(name = "ExcluirItemCarrinho", urlPatterns = {"/excluirItem"})
public class ExcluirItemCarrinho extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

        if (sessao.getAttribute("produtosAttr") == null) {
            sessao.setAttribute("produtosAttr", new ArrayList<ItemVenda>());
        }

        try {

            List<ItemVenda> intensCarrinho = (List<ItemVenda>) sessao.getAttribute("produtosAttr");

            for (int i = 0; i < intensCarrinho.size(); i++) {
                if (intensCarrinho.get(i).getProduto().getId() == id) {
                    intensCarrinho.remove(i);
                }
            }
            sessao.setAttribute("produtosAttr", intensCarrinho);
        } catch (Exception e) {
            System.out.println(e);

        }

       response.sendRedirect(request.getContextPath() +"/carrinho");

    }
}
