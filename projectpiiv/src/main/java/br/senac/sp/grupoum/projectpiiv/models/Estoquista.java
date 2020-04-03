/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

public class Estoquista extends Funcionario {

    public Estoquista() {

    }

    public Estoquista(String email, String senha, int id, String nome) {
        super(email, senha, id, nome);
    }
    
    public Estoquista(String email, String senha, String nome){ 
        super(email, senha, nome);
    }

}
