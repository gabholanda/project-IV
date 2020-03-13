package com.br.senac.sp.grupoum.projectpiiv.Controllers;

import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class ProductController {
    
    @Autowired
            ProductRepository produtoRepository;
    
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }
    
    @GetMapping("/product")
    public List<Product> getProducts() {
        return produtoRepository.findAll();
    }
    
    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        return produtoRepository.save(product);
    }
    
    @PutMapping("/product")
    public Product update(@RequestBody Product product) {
        return produtoRepository.save(product);
    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
       Product product = produtoRepository.findById(id);
       produtoRepository.delete(product);
       return ResponseEntity.ok().build();
    }
   
}
