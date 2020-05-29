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
 * @author pablo.santana
 */
@WebServlet(name = "CancelarCompraServlet", urlPatterns = {"/cancelar-venda"})
public class CancelarCompraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        try{
            
        sessao.removeAttribute("produtosAttr");
        sessao.removeAttribute("totalAttr");
        sessao.removeAttribute("vendaAttr");
        response.sendRedirect(request.getContextPath() + "/land");
        
        }catch(Exception e){
            System.out.println("" + e);
        }
    }

}
