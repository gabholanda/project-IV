package com.br.senac.sp.grupoum.projectpiiv.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ProductRepository;

@Controller
public class StockistController {
	
	@Autowired
	ProductRepository produtoRepository;

	@GetMapping("/estoquista")
	public ModelAndView initialPage() {
		return new ModelAndView("estoquista");
	}
	
	@GetMapping("/estoquista/listar-produtos")
    public ModelAndView listarProduto() {
    	List<Product> products = produtoRepository.findAll();
        return new ModelAndView("listar-produtos-estoquista").addObject("produtosAttr", products);
    }
	
    @GetMapping("/estoquista/editar-produto")
    public ModelAndView editarProduto(@RequestParam(value = "id") long id) {
        Product product = produtoRepository.findById(id);
        
        return new ModelAndView("editar-produto-estoquista").addObject("produto", product);
        
    }
    
    @PostMapping("/estoquista/editar-produto")
    public ModelAndView update(@ModelAttribute Product product) {
    	long id = product.getId();
    	
        Product produto = produtoRepository.findById(id);
        produto.setQuantity(product.getQuantity());
        
        if (produtoRepository.save(produto) != null) {
        	return new ModelAndView("estoquista").addObject("editadoAttr", true);
        } else {
        	return new ModelAndView("editar-produto-estoquista");
        }
    }

}
