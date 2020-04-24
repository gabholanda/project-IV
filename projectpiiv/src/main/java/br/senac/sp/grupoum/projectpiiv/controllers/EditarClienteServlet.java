/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.services.ValidarCep;
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
 * sessao.setAttribute("usuario", cliente);
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "EditarClienteServlet", urlPatterns = {"/editar-cliente"})
public class EditarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-cliente.jsp");
        Cliente cliente = (Cliente) sessao.getAttribute("usuario");

        try {
            if (cliente != null) {
                request.setAttribute("nomeAttr", cliente.getNome());
                request.setAttribute("sobreNomeAttr", cliente.getSobreNome());
                request.setAttribute("cpfAttr", cliente.getCpf());
                request.setAttribute("enderecoAttr", cliente.getEndereco());
                request.setAttribute("cepAttr", cliente.getCep());
                request.setAttribute("emailAttr", cliente.getEmail());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        try{
        String nome = request.getParameter("nome");
        String sobreNome = request.getParameter("sobrenome");
        String cpf = (String) request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");

        if (!ValidarCep.encontrarCep(cep)) {
            request.setAttribute("msgErro", "CEP não encontrado");
            request.getRequestDispatcher("/WEB-INF/editar-cliente.jsp").forward(request, response);
        } else {
            Cliente cliente = new Cliente(nome, sobreNome, cpf, endereco, cep, email);

            boolean salvou = ClienteDAO.editar(cliente);

            if (salvou) {

                sessao.setAttribute("usuario", cliente);
                request.setAttribute("alteradoAttr", true);
                response.sendRedirect(request.getContextPath() + "/land");
            } else {
                request.setAttribute("msgErro", "Houve um erro, tente novamente");
                request.getRequestDispatcher("/WEB-INF/editar-cliente.jsp").forward(request, response);
            }
        }
        }catch(Exception ex ){
            request.setAttribute("msgErro", "Houve um erro, tente novamente");
            request.getRequestDispatcher("/WEB-INF/editar-cliente.jsp").forward(request, response);
        }
    }

}
