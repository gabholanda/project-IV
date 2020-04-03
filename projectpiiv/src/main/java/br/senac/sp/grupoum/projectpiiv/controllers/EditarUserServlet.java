/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Admin;
import br.senac.sp.grupoum.projectpiiv.models.AutenticadorEmail;
import br.senac.sp.grupoum.projectpiiv.models.Estoquista;
import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import dao.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditarUserServlet", urlPatterns = {"/admin/editar-usuario"})
public class EditarUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-usuario.jsp");
        int id = Integer.parseInt(request.getParameter("id"));

        Funcionario funcionario = FuncionarioDAO.pesquisaId(id);

        request.setAttribute("idAttr", id);
        request.setAttribute("nomeAttr", funcionario.getNome());
        request.setAttribute("senhaAttr", funcionario.getSenha());

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");
        
        request.setAttribute("idAttr", id);
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("senhaAttr", senha);
        
        Funcionario funcionario;
        boolean salvou = false;

        int tamanhoNome = nome.length();
        if (tamanhoNome < 5) {
            boolean erroNome = false;
            request.setAttribute("ErroNome", erroNome);
            request.getRequestDispatcher("/WEB-INF/editar-usuario.jsp")
                    .forward(request, response);
        }
        //
        if (tipo.equals("admin")) {
            funcionario = new Admin(id, senha, nome, tipo, salvou);
            salvou = FuncionarioDAO.editar(funcionario);
        } else if (tipo.equals("estoquista")) {
            funcionario = new Estoquista(id, senha, nome, tipo, salvou);
            salvou = FuncionarioDAO.editar(funcionario);
        }
        if (salvou) {
            request.setAttribute("editadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listar-usuarios.jsp");
            dispatcher.forward(request, response);
        }
    }
}
