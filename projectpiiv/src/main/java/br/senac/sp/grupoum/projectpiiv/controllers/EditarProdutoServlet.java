package br.senac.sp.grupoum.projectpiiv.controllers;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import com.oreilly.servlet.MultipartRequest;
import dao.ProdutoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
        ServletContext servletContext = request.getServletContext();

        String UPLOAD_PATH = servletContext.getRealPath("/img").replace("/target/projectpiiv-1.0-SNAPSHOT", "/src/main/webapp");
        UPLOAD_PATH = UPLOAD_PATH.replace("/target/projectpiiv-1.0-SNAPSHOT", "/src/main/webapp");
        MultipartRequest m = new MultipartRequest(request, UPLOAD_PATH, 1024 * 1024 * 1024);

        //\target\projectpiiv-1.0-SNAPSHOT\img
        if (ServletFileUpload.isMultipartContent(request)) {
            try {

                Enumeration files = m.getFileNames();
                ArrayList<File> uploadedFiles = new ArrayList<>();

                while (files.hasMoreElements()) {
                    String name = (String) files.nextElement();
                    File uploadedFile = m.getFile(name);
                    uploadedFiles.add(uploadedFile);
                }

                String nome = m.getParameter("nome");
                String descricao = m.getParameter("descricao");
                String tipo = m.getParameter("tipo");
                double preco = Double.valueOf(m.getParameter("preco"));
                double quantidade = Double.valueOf(m.getParameter("quantidade"));
                Produto produto = new Produto(nome, descricao, tipo, preco, quantidade);

                boolean salvar = ProdutoDAO.editar(produto, uploadedFiles);
                if (salvar) {
                    request.setAttribute("criadoAttr", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");

                    dispatcher.forward(request, response);
                }

                request.setAttribute("message", "Arquivo carregado com sucesso");
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
            }

        } else {
            request.setAttribute("message", "E necessario o upload de alguma imagem");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-produto.jsp");
        dispatcher.forward(request, response);
    }

}
