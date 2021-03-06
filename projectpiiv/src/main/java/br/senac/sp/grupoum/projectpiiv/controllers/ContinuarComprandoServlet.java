package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author erickgurian
 */
@WebServlet(name = "ContinuarComprandoServlet", urlPatterns = {"/continuar-comprando"})
public class ContinuarComprandoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("produtosAttr") == null) {
            sessao.setAttribute("produtosAttr", new ArrayList<ItemVenda>());
        }
        ArrayList<ItemVenda> itensCarrinho = (ArrayList<ItemVenda>) sessao.getAttribute("produtosAttr");

        double total = 0;

        try {

            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                int qtd = Integer.parseInt(request.getParameter("qtdProduto_" + id));
                System.out.println(qtd);
                Produto produto = ProdutoDAO.pesquisarPorId(id);

                if (!itensCarrinho.isEmpty()) {
                    int existe = existe(itensCarrinho, id);
                    if (existe >= 0) {
                        itensCarrinho.get(existe).setQuantidade(qtd);
                    } else {

                        ItemVenda item = new ItemVenda(produto, qtd);

                        itensCarrinho.add(item);

                    }

                } else {

                    ItemVenda item = new ItemVenda(produto, qtd);

                    itensCarrinho.add(item);

                }

                sessao.setAttribute("produtosAttr", itensCarrinho);

            } else {
                sessao.setAttribute("produtosAttr", itensCarrinho);
            }
        } catch (NumberFormatException ex) {
            System.out.println("fail" + ex);
        }
        for (int i = 0; i < itensCarrinho.size(); i++) {
            total = total + Double.parseDouble(itensCarrinho.get(i).vlrTotalItemF().replace(",", "."));
        }

        sessao.setAttribute("totalAttr", total);
        response.sendRedirect(request.getContextPath() + "/carrinho");
        
    }
    
    private int existe(ArrayList<ItemVenda> itensCarrinho, int id) {    
        for (int i = 0; i < itensCarrinho.size(); i++) {
            if (itensCarrinho.get(i).getProduto() != null) {
                if(itensCarrinho.get(i).getProduto().getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }

}
