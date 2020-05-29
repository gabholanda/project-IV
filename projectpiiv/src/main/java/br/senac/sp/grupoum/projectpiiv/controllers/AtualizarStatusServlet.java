/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Venda;
import dao.VendaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo.santana
 */
@WebServlet(name = "AtualizarStatusServlet", urlPatterns = {"/estoquista/atualizar-status"})
public class AtualizarStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atualizar-status.jsp");
        
        int idVenda= Integer.parseInt(request.getParameter("id"));
      
        Venda venda = VendaDAO.pesquisarPorId(idVenda);
        
        request.setAttribute("vendaAttr", venda);
        dispatcher.forward(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/estoquista.jsp");
        
        try{
            int idVenda = Integer.parseInt(request.getParameter("idVenda"));
            String status = request.getParameter("status");

            if(VendaDAO.atualizarStatus(idVenda, status)){
                request.setAttribute("alteradoAttr", true);
            }
        
        }catch(Exception e ){
            System.out.println("AQUI O ERRO " + e);
        }
        
         dispatcher.forward(request, response);
    }

}
