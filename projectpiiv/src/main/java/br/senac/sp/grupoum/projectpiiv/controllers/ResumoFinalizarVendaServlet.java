/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Venda;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ResumoFinalizarVendaServlet", urlPatterns = {"/resumo-venda"})
public class ResumoFinalizarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Venda vendaClilente = (Venda) sessao.getAttribute("vendaAttr");
        
        
        sessao.setAttribute("vendaAttr", vendaClilente);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resumo-venda.jsp");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        Venda vendaCliente =(Venda) sessao.getAttribute("vendaAttr");
        boolean salvou = false;
        try {
            salvou = VendaDAO.finalizarVenda(vendaCliente);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResumoFinalizarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(salvou){
            sessao.removeAttribute("produtosAttr");
            sessao.removeAttribute("totalAttr");
            sessao.removeAttribute("vendaAttr");
            response.sendRedirect(request.getContextPath() + "/meus-pedidos");
        }
        
    }

}
