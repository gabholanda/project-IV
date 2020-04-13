/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.br.senac.sp.grupoum.projectpiiv.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imagem_produto")
public class Images implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@Column(name="caminho_imagem")
    private String imagePath;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Product product;
    
    public Images() {
    }

    public Images(Product product, String imagePath) {
        this.imagePath = imagePath;
        this.product = product;
    }

    public Images(int id, Product product, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

