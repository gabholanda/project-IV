/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

public class Funcionario extends Usuario {

    private int idUser;
    private String nome;

    public Funcionario(String email, String senha, int idUser, String nome) {

        super(email, senha);
        this.idUser = idUser;
        this.nome = nome;

    }

    public Funcionario(String email, String senha, String nome) {

        super(email, senha);
        this.nome = nome;

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

}
