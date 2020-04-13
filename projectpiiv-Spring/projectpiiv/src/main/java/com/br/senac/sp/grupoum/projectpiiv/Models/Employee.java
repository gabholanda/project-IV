package com.br.senac.sp.grupoum.projectpiiv.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;
	
	@Column(name="Nome")
	private String name;
	
	@Column(name="Tipo")
    private String type;
	
	@Column(name="status")
    private boolean status;
	
    private int permitido;
    
    @OneToOne
    @JoinColumn(name="id_usuario")
    private User user;
    
    public Employee() {}
    
    public Employee(String name, String type, boolean status, User user) {
    	this.name = name;
    	this.type = type;
    	this.status = status;
    	this.user = user;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getPermitido() {
		return permitido;
	}

	public void setPermitido(int permitido) {
		this.permitido = permitido;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
