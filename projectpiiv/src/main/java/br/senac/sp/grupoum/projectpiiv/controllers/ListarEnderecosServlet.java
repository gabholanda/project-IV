/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.models.Endereco;
import br.senac.sp.grupoum.projectpiiv.models.Venda;
import dao.ClienteDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author marcelo.moraes
 */
@WebServlet(name = "ListarEnderecosServlet", urlPatterns = {"/listar-enderecos"})
public class ListarEnderecosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        RequestDispatcher dispatcher;

        if (sessao.getAttribute("usuario") != null) {
            Cliente cliente = (Cliente) sessao.getAttribute("usuario");
            ArrayList<Endereco> endereco = ClienteDAO.enderecoPorCliente(cliente);

            dispatcher = request.getRequestDispatcher("/WEB-INF/listar-enderecos.jsp");
            request.setAttribute("entregaAttr", endereco);
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
