package br.senac.sp.grupoum.projectpiiv.controllers;

import dao.ProdutoDAO;
import java.io.IOException;
import br.senac.sp.grupoum.projectpiiv.models.Produto;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
@WebServlet(name = "ListarProdutosServlet", urlPatterns = {"/admin/listar-produtos"})
public class ListarProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listar-produtos.jsp");

        ArrayList<Produto> produtos = ProdutoDAO.produtosCadastrados();

        request.setAttribute("produtosAttr", produtos);
       
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}