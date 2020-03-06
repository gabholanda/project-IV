package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditarProdutoServlet", urlPatterns = {"/admin/editar-produto"})
public class EditarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-produto.jsp");
        Produto produto = ProdutoDAO.pesquisarPorId(id);

        try {
            if (produto != null) {
                request.setAttribute("idAttr", id);
                request.setAttribute("nomeAttr", produto.getNome());
                request.setAttribute("descricaoAttr", produto.getDescricao());
                request.setAttribute("precoAttr", produto.getPreco());
                request.setAttribute("qtdAttr", produto.getQuantidade());
                request.setAttribute("tipoAttr", produto.getTipo());
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

        int id = Integer.parseInt(request.getParameter("id"));

        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        double quantidade = Double.parseDouble(request.getParameter("quantidade"));

        Produto produto = new Produto(id, nome, descricao, tipo, preco, quantidade);

        boolean editou = ProdutoDAO.editar(produto);

        if (editou) {
            request.setAttribute("editadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-produto.jsp");
            dispatcher.forward(request, response);
            
        }

    }

}
