/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaUsuariosServlet", urlPatterns = {"/admin/listar-usuarios"})
public class ListaUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listar-usuarios.jsp");

        ArrayList<Funcionario> funcionarios = FuncionarioDAO.usuariosCadastrados();

        request.setAttribute("funcionariosAttr", funcionarios);
       
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
