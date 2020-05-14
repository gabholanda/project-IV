package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.models.Venda;
import dao.VendaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erickgurian
 */
@WebServlet(name = "MeusPedidosServlet", urlPatterns = {"/meus-pedidos"})
public class MeusPedidosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        RequestDispatcher dispatcher;
        
        if (sessao.getAttribute("usuario") != null) {
            Cliente cliente = (Cliente) sessao.getAttribute("usuario");
            ArrayList<Venda> vendas = VendaDAO.vendasPorCliente(cliente.getIdCliente());
            
            dispatcher = request.getRequestDispatcher("/WEB-INF/meus-pedidos.jsp");
            request.setAttribute("pedidosAttr", vendas);
        } else {
            dispatcher = request.getRequestDispatcher("/WEB-INF/login-cliente.jsp");
            request.setAttribute("fazerLoginAttr", "Faça login para ver seus pedidos");
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
