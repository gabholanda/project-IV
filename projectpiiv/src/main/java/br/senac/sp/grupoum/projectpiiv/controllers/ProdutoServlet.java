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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Collectors;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.apache.commons.fileupload.FileItemFactory;

@MultipartConfig
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/admin/cadastrar-produto"})
public class ProdutoServlet extends HttpServlet {
    private final String UPLOAD_PATH = "/home/gabriel";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     MultipartRequest m = new MultipartRequest(request, UPLOAD_PATH, 1024 * 1024 * 1024);
    
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                request.setCharacterEncoding("UTF-8");
                
                Enumeration files = m.getFileNames();
                ArrayList <File> uploadedFiles = new ArrayList<>();
                while(files.hasMoreElements()) {
                    String name = (String) files.nextElement();
                    String fileName = m.getFilesystemName(name);
                    File uploadedFile = m.getFile("file");
                    uploadedFiles.add(uploadedFile);
                }
                String nome = m.getParameter("nome");
                String descricao = m.getParameter("descricao");
                String tipo = m.getParameter("tipo");
                double preco = Double.valueOf(m.getParameter("preco"));
                double quantidade = Double.valueOf(m.getParameter("quantidade"));
                Produto produto = new Produto(nome, descricao, tipo, preco, quantidade);
                ProdutoDAO salvarProduto = new ProdutoDAO();
                boolean salvar = salvarProduto.salvar(produto, uploadedFiles);
                if (salvar) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");

                    dispatcher.forward(request, response);
                }

                request.setAttribute("message", "Arquivo carregado com sucesso");
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
            }

        } else {
            request.setAttribute("message", "E necessario o upload de alguma imagem");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        dispatcher.forward(request, response);
    }
}

