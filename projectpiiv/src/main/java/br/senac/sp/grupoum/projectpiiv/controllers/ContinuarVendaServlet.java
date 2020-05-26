/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Cliente;
import br.senac.sp.grupoum.projectpiiv.models.ItemVenda;
import br.senac.sp.grupoum.projectpiiv.models.Venda;
import br.senac.sp.grupoum.projectpiiv.models.Endereco;
import dao.EnderecoDAO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ContinuarVendaServlet", urlPatterns = {"/continuarVenda"})
public class ContinuarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("produtosAttr") == null) {
            sessao.setAttribute("produtosAttr", new ArrayList<ItemVenda>());
        }

        double total = Double.parseDouble(sessao.getAttribute("totalAttr").toString());
        ArrayList<ItemVenda> itensCarrinho = (ArrayList<ItemVenda>) sessao.getAttribute("produtosAttr");

        try {
            if (sessao.getAttribute("usuario") == null) {
                response.sendRedirect(request.getContextPath() + "/login-cliente");
            } else {
                  if (request.getParameter("id") != null) {
                   int id = Integer.parseInt(request.getParameter("id"));
                   Endereco endereco = EnderecoDAO.pesquisarPorId(id);
                     Cliente cliente = (Cliente) sessao.getAttribute("usuario");
                

                    Venda vendaCliente = new Venda(itensCarrinho, total, cliente.getIdCliente());
                    vendaCliente.setEndereco(endereco);

                    sessao.setAttribute("vendaAttr", vendaCliente);
                    response.sendRedirect(request.getContextPath() + "/forma-pagamento");
                  }else{
                  sessao.setAttribute("msgErro", "Por favor, selecione um endereço para prosseguir.");
                  response.sendRedirect(request.getContextPath() + "/listar-enderecos");
                  }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
