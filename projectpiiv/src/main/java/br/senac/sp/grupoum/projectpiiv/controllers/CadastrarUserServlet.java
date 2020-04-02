/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Admin;
import br.senac.sp.grupoum.projectpiiv.models.Estoquista;
import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.text.ParseException;
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
 * @author Administrator
 */
@WebServlet(name = "CadastrarUserServlet", urlPatterns = {"/admin/cadastrar-usuario"})
public class CadastrarUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-usuario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");
        Funcionario funcionario;
        boolean salvou = false;
        if (tipo.equals("admin")) {
            funcionario = new Admin(email, senha, nome);
            salvou = FuncionarioDAO.salvar(funcionario);
        } else if (tipo.equals("estoquista")) {
            funcionario = new Estoquista(email, senha, nome);
            salvou = FuncionarioDAO.salvar(funcionario);
        }
        if (salvou) {
            request.setAttribute("criadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-usuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
