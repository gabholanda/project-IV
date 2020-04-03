/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

public class Admin extends Funcionario {

    public Admin() {

    }

    public Admin(String email, String senha, int id, String nome, String tipo, boolean status) {
        super(email, senha, id, nome, tipo, status);
    }

    public Admin(String email, String senha, String nome, String tipo, boolean status) {
        super(email, senha, nome,tipo, status );
    }

}
