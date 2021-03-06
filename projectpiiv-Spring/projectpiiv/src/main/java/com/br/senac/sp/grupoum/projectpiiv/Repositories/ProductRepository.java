package com.br.senac.sp.grupoum.projectpiiv.Repositories;

import com.br.senac.sp.grupoum.projectpiiv.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Product findById(long id);
    
}
