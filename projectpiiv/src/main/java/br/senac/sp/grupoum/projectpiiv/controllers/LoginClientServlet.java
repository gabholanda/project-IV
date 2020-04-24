/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.services.Encriptografar;
import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "LoginClientServlet", urlPatterns = {"/login-cliente"})
public class LoginClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/login-cliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usuario = request.getParameter("usuario");
        String senha = Encriptografar.criptografar(request.getParameter("senha"));
        
        Cliente cliente = ClienteDAO.autenticar(usuario, senha);
        if(cliente !=null){
        
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", cliente);
            
            request.setAttribute("LogadoAttr", true);
            request.setAttribute("nLogadoAttr", false);
            response.sendRedirect(request.getContextPath() + "/land");
        }
        else{
             request.setAttribute("msgErro", "Usuário ou senha incorreta");
             request.getRequestDispatcher("/WEB-INF/login-cliente.jsp").forward(request, response);
        }
    }
}
