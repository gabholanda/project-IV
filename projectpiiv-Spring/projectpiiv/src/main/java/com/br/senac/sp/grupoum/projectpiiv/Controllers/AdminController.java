package com.br.senac.sp.grupoum.projectpiiv.Controllers;

import com.br.senac.sp.grupoum.projectpiiv.Models.Employee;
import com.br.senac.sp.grupoum.projectpiiv.Models.Images;
import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import com.br.senac.sp.grupoum.projectpiiv.Models.User;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.EmployeeRepository;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ImagesRepository;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ProductRepository;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	private static String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static/img/"; 
    
    @Autowired
    ProductRepository produtoRepository;
    
    @Autowired
    ImagesRepository imageRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/admin")
    public ModelAndView initialPage() {
        return new ModelAndView("admin");
    }
    
    @GetMapping("/admin/cadastrar-produto")
    public ModelAndView cadastrarProduto() {
        return new ModelAndView("cadastrar-produto");
    }
    
    @PostMapping("/admin/cadastrar-produto")
    public ModelAndView create(@ModelAttribute Product product, @RequestParam("images") MultipartFile[] files) {
    	byte[] bytes;
        Product produto = produtoRepository.save(product);
        
        for (MultipartFile file : files) {
        	try {
    			bytes = file.getBytes();
    			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
    	        Files.write(path, bytes);
    	    
    	        Images imagem = new Images(produto, file.getOriginalFilename());
    	        imageRepository.save(imagem);
    	        
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
        if (produto != null) {
        	return new ModelAndView("admin").addObject("criadoAttr", true);
        } else {
        	return new ModelAndView("cadastrar-produto");
        }
        
    }
    
    @GetMapping("/admin/editar-produto")
    public ModelAndView editarProduto(@RequestParam(value = "id") long id) {
        Product product = produtoRepository.findById(id);
        
        return new ModelAndView("editar-produto").addObject("produto", product);
        
    }
   
    @PostMapping("/admin/editar-produto")
    public ModelAndView update(@ModelAttribute Product product, @RequestParam("images") MultipartFile[] files) {	
    	byte[] bytes;
        Product produto = produtoRepository.save(product);
        
        for (MultipartFile file : files) {
        	try {
    			bytes = file.getBytes();
    			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
    	        Files.write(path, bytes);
    	    
    	        Images imagem = new Images(produto, file.getOriginalFilename());
    	        imageRepository.save(imagem);
    	        
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
        if (produto != null) {
        	return new ModelAndView("admin").addObject("editadoAttr", true);
        } else {
        	return new ModelAndView("editar-produto");
        }
    }
    
    @GetMapping("/admin/listar-produtos")
    public ModelAndView listarProduto() {
    	List<Product> products = produtoRepository.findAll();
        return new ModelAndView("listar-produtos").addObject("produtosAttr", products);
    }
    
    
    @PostMapping("/admin/excluir-produto")
    public ModelAndView delete(@RequestParam(value = "id") long id) {
        Product product = produtoRepository.findById(id);
        produtoRepository.delete(product);
        return new ModelAndView("admin").addObject("excluidoAttr", true);
        
    }
    
    @GetMapping("/admin/cadastrar-usuario")
    public ModelAndView cadastrarUsuario() {
        return new ModelAndView("cadastrar-usuario");
    }
    
    @PostMapping("/admin/cadastrar-usuario")
	public ModelAndView createUser(@ModelAttribute Employee employee, @ModelAttribute User user) {
    	
    	Employee funcionario = employeeRepository.save(employee);
    	int id = funcionario.getId();
    	user.setId(id);
    	
    	User usuario = userRepository.save(user);

		if (funcionario != null && usuario != null) {
			return new ModelAndView("admin").addObject("criadoAttr", true);
		} else {
			return new ModelAndView("cadastrar-usuario");
		}

	}
    
    @GetMapping("/admin/editar-usuario")
    public ModelAndView editarUsuario(@RequestParam(value = "id") int id) {
        Employee employee = employeeRepository.findById(id);
        
        return new ModelAndView("editar-usuario").addObject("funcionario", employee);
        
    }
    
    @PostMapping("/admin/editar-usuario")
	public ModelAndView editUser(@ModelAttribute Employee employee, @ModelAttribute User user) {
    	
    	Employee funcionario = employeeRepository.save(employee);
    	int id = funcionario.getId();
    	user.setId(id);
    	
    	User usuario = userRepository.save(user);

		if (funcionario != null && usuario != null) {
			return new ModelAndView("admin").addObject("editadoAttr", true);
		} else {
			return new ModelAndView("editar-usuario");
		}

	}
    
    @GetMapping("/admin/listar-usuarios")
    public ModelAndView listarUsuario() {
    	List<Employee> employees = employeeRepository.findAll();
        return new ModelAndView("listar-usuarios").addObject("funcionariosAttr", employees);
    }
    
    @PostMapping("/admin/excluir-usuario")
    public ModelAndView deleteUser(@RequestParam(value = "id") int id) {
        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);
        return new ModelAndView("admin").addObject("excluidoAttr", true);
        
    }
    
}