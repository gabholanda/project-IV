package com.br.senac.sp.grupoum.projectpiiv.Controllers;

import com.br.senac.sp.grupoum.projectpiiv.Models.Employee;
import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import com.br.senac.sp.grupoum.projectpiiv.Models.User;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.EmployeeRepository;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.ProductRepository;
import com.br.senac.sp.grupoum.projectpiiv.Repositories.UserRepository;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Api(value="API Rest Produto")
@CrossOrigin(origins="*")
public class ProductController {
    
    @Autowired
            ProductRepository produtoRepository;
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @GetMapping("/product/{id}")
    public Product findById(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }
    
    @GetMapping("/product")
    public List<Product> findAll() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/user")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    
    @GetMapping("/employee")
    public List<Employee> findAllemp() {
        return employeeRepository.findAll();
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
