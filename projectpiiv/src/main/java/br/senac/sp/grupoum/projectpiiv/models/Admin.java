/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import br.senac.sp.grupoum.projectpiiv.enums.Tipo;

public class Admin extends Funcionario {

    private String tipo = Tipo.ADMIN.getPermissao();

    public Admin() {

    }

    public Admin(String email, String senha, int id, String nome, String tipo, boolean status) {
        super(email, senha, id, nome, tipo, status);
    }

    public Admin(String email, String senha, String nome, String tipo, boolean status) {
        super(email, senha, nome, tipo, status);
    }

    public Admin(int idUser, String senha, String nome, String tipo, boolean status) {
        super(idUser, senha, nome, tipo, status);
    }

}
