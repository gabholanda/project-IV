package com.br.senac.sp.grupoum.projectpiiv.Controllers;

import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	@Autowired
	ProductRepository produtoRepository;

	@GetMapping("/")
	public ModelAndView initialPage() {
		List<Product> products = produtoRepository.findAll();
		return new ModelAndView("land-page").addObject("produtosAttr", products);
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@GetMapping("/detalhe-produto")
	public ModelAndView productDetails(@RequestParam(value = "id") long id) {
		Product product = produtoRepository.findById(id);

		return new ModelAndView("detalhes-produto").addObject("produto", product);

	}

}