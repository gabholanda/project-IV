/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.models.Endereco;

import dao.ClienteDAO;

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
 * @author Administrator
 */
@WebServlet(name = "EnderecoServlet", urlPatterns = {"/enderecos"})
public class EnderecoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        RequestDispatcher dispatcher;

        if (sessao.getAttribute("usuario") != null) {
            Cliente cliente = (Cliente) sessao.getAttribute("usuario");
            Endereco endereco = ClienteDAO.pesquisarPorId2(cliente.getIdCliente());

            dispatcher = request.getRequestDispatcher("/WEB-INF/enderecos.jsp");
            request.setAttribute("enderecoAttr", endereco);
        } else {
            dispatcher = request.getRequestDispatcher("/WEB-INF/login-cliente.jsp");
            request.setAttribute("fazerLoginAttr", "Faça login para ver endereços");
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Cliente cliente = (Cliente) sessao.getAttribute("usuario");

        int id_cliente = cliente.getIdCliente();
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String tipo = request.getParameter("tipo");

        try {
            
             if (cep.equals("")) {
                request.setAttribute("msgErro", "Cep Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
            }
             
             else if (rua.equals("")) {
                request.setAttribute("msgErro", "Rua Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
            }
             
             else if (numero.equals("")) {
                request.setAttribute("msgErro", "Numero Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
            }
             
             else if (complemento.equals("")) {
                request.setAttribute("msgErro", "Complemento Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
            }
             
             else if (bairro.equals("")) {
                request.setAttribute("msgErro", "Bairro Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
            }
             
             else if (cidade.equals("")) {
                request.setAttribute("msgErro", "Cidade Campo Vazio");
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
                return;
             }
             
             

            Endereco end = new Endereco(cliente, cep, rua, numero, complemento, bairro, cidade, estado, tipo);

            if (ClienteDAO.cadastrarEndereco(end)) {
                request.setAttribute("criadoAttr", true);
                request.getRequestDispatcher("WEB-INF/enderecos.jsp").forward(request, response);
            } else {
                request.setAttribute("msgErro", "Houve um erro inesperado");
                response.sendRedirect(request.getContextPath() + "/enderecos");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
