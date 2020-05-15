package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Venda;
import dao.VendaDAO;
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
 * @author erickgurian
 */
@WebServlet(name = "DetalhesPedidoServlet", urlPatterns = {"/detalhes-pedido"})
public class DetalhesPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
         Venda venda = VendaDAO.pesquisarPorId(id);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/detalhes-pedido.jsp");
         request.setAttribute("vendaAttr", venda);
         dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
