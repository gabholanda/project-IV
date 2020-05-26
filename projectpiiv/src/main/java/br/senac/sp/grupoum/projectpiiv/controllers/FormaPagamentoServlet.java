package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FormaPagamentoServlet", urlPatterns = {"/forma-pagamento"})
public class FormaPagamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/forma-pagamento.jsp");
        
        dispatcher.forward(request, response);
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pagamentoAttr = request.getParameter("pagamento");
        String pagamento = "";
        HttpSession sessao = request.getSession();
        
        if (pagamentoAttr.equals("boleto")) {
            pagamento = "Boleto";
        } else {
            pagamento = "Cartão de Crédito";
        }
        
        Venda venda = (Venda) sessao.getAttribute("vendaAttr");
        venda.setMetodoPagamento(pagamento);
        venda.setValorFrete(20.00);
        venda.setValorTotal(venda.getValorTotal() + venda.getValorFrete());
        sessao.setAttribute("vendaAttr", venda);
        
        response.sendRedirect(request.getContextPath() + "/resumo-venda");
    }

}
