/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.services.Encriptografar;
import br.senac.sp.grupoum.projectpiiv.services.ValidarCep;
import dao.ClienteDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "CadastrarClienteServlet", urlPatterns = {"/cadastrar-cliente"})
public class CadastrarClienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/cadastrar-cliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf").replace(".", "").replace("-", "");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep").replace("-", "");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try {
            if (ClienteDAO.buscarCpf(cpf)) {
                request.setAttribute("msgErro", "CPF já cadastrado");
                request.getRequestDispatcher("WEB-INF/cadastrar-cliente.jsp").forward(request, response);
                return;
            }
            
            if (ClienteDAO.buscarEmail(email)) {
                request.setAttribute("msgErro", "Email já cadastrado");
                request.getRequestDispatcher("WEB-INF/cadastrar-cliente.jsp").forward(request, response);
                return;
            }
            
            if (!ValidarCep.encontrarCep(cep)) {
                request.setAttribute("msgErro", "CEP não encontrado");
                request.getRequestDispatcher("WEB-INF/cadastrar-cliente.jsp").forward(request, response);
                return;
            }

            Cliente cliente = new Cliente(nome, sobrenome, cpf, endereco, cep, email, Encriptografar.criptografar(senha));
            
            if (ClienteDAO.salvar(cliente)) {
                request.setAttribute("criadoAttr", true);
                request.getRequestDispatcher("WEB-INF/cadastrar-cliente.jsp").forward(request, response);
            } else {
                request.setAttribute("msgErro", "Houve um erro inesperado");
                response.sendRedirect(request.getContextPath() + "/cadastrar-cliente");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
