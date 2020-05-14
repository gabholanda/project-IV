package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
import br.senac.sp.grupoum.projectpiiv.models.Produto;
import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablo.santana
 */
@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/carrinho"})
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/carrinho.jsp");

        List<ItemVenda> intensCarrinho = (List<ItemVenda>) sessao.getAttribute("produtosAttr");
        double total = 0;

        try {

            if (sessao.getAttribute("produtosAttr") == null) {
                sessao.setAttribute("produtosAttr", new ArrayList<ItemVenda>());
            }

            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                int qtd = Integer.parseInt(request.getParameter("qtdProduto"));

                Produto produto = ProdutoDAO.pesquisarPorId(id);

                ItemVenda item = new ItemVenda(produto, qtd);

                intensCarrinho.add(item);

                sessao.setAttribute("produtosAttr", intensCarrinho);

            } else {
                sessao.setAttribute("produtosAttr", intensCarrinho);
            }
        } catch (NumberFormatException ex) {
            System.out.println("fail" + ex);
        }
        for (int i = 0; i < intensCarrinho.size(); i++) {
            total = total + Double.parseDouble(intensCarrinho.get(i).vlrTotalItemF().replace(",", "."));
        }

        sessao.setAttribute("totalAttr", total);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//          HttpSession sessao = request.getSession();
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        
//        if (sessao.getAttribute("clienteAttr") == null && request.getParameter("id")!= null) {
//            int idCliente = Integer.parseInt(request.getParameter("id"));
//            Cliente cliente = cDao.pesquisarPorId(idCliente);
//            sessao.setAttribute("clienteAttr", cliente);
//        }
//
//        List<Produto> produtos = pDao.pesquisarProdutos(idFilial);
//        try {
//            if (produtos != null) {
//                request.setAttribute("produtosAttr", produtos);
//                request.getRequestDispatcher("/WEB-INF/realizar-venda.jsp").forward(request, response);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }   
//        
//        
    }

}
