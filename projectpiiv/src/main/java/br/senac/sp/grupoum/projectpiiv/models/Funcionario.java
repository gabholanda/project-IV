/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

public class Funcionario extends Usuario {

    private int idUser;
    private String nome;
    private String tipo;
    private boolean status;
    private int permitido;

    public Funcionario(String email, String senha, int idUser, String nome, String tipo, boolean status) {

        super(email, senha);
        this.idUser = idUser;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;

    }

    public Funcionario(String email, String senha, String nome, String tipo, boolean status) {

        super(email, senha);
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;

    }

    public Funcionario(int idUser, String senha, String nome, String tipo, boolean status) {
        super(senha);
        this.idUser = idUser;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Funcionario() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPermitido() {
        return permitido;
    }

    public void setPermitido(int permitido) {
        this.permitido = permitido;
    }

}
