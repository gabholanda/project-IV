package br.senac.sp.grupoum.projectpiiv.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import br.senac.sp.grupoum.projectpiiv.models.Usuario;
import br.senac.sp.grupoum.projectpiiv.models.Funcionario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("usuario") != null) {
            Usuario usuario = (Usuario) sessao.getAttribute("usuario");
            String url = usuario.montarUrl();

            response.sendRedirect(request.getContextPath() + url);
            return;
        }

        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario usuario = (Funcionario) UserDAO.buscarEmail(email);
        try {

            if (usuario != null && senha.equals(usuario.getSenha()) && usuario.getPermitido()== 0) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                String url = usuario.montarUrl();

                response.sendRedirect(request.getContextPath() + url);
            } else {

                request.setAttribute("msgErro", "Usuário ou senha incorreta");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
