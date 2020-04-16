package com.br.senac.sp.grupoum.projectpiiv.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_produto")
    private Long id;
    @Column(name="Nome")
    private String name;
    @Column(name="Descricao")
    private String description;
    @Column(name="tipo_produto")
    private String type;
    
    @OneToMany(mappedBy = "product")
    private List<Images> images = new ArrayList<>();
    
    @Column(name="preco")
    private double price;
    @Column(name="qtd_estoque")
    private double quantity;
    
    public Product() {
    }

    public Product(String name, String description, String type, double price, double quantity) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Long id, String name, String description, String type, double price, double quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Images> getImages() {
        return images;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
}


