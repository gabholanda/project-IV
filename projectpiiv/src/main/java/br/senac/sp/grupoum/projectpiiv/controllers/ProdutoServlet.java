package br.senac.sp.grupoum.projectpiiv.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.senac.sp.grupoum.projectpiiv.models.Produto;
import com.oreilly.servlet.MultipartRequest;
import dao.ProdutoDAO;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.apache.commons.fileupload.FileItemFactory;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/admin/cadastrar-produto"})
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        double quantidade = Double.parseDouble(request.getParameter("quantidade"));
       
        Produto produto = new Produto(nome, descricao, tipo, preco, quantidade);
    
        boolean salvou = ProdutoDAO.salvar(produto);

        if (salvou) {
            request.setAttribute("criadoAttr", true);
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
            dispatcher.forward(request, response);
        }
    }
}
