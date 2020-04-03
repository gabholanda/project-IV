/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import br.senac.sp.grupoum.projectpiiv.enums.Tipo;

public class Estoquista extends Funcionario {

    private String tipo = Tipo.ESTOQUISTA.getPermissao();
    public Estoquista() {

    }

    public Estoquista(String email, String senha, int id, String nome, String tipo, boolean status) {
        super(email, senha, id, nome, tipo, status);
    }
    
    public Estoquista(String email, String senha, String nome, String tipo, boolean status){ 
        super(email, senha, nome, tipo, status);
    }

    public Estoquista(int idUser, String senha, String nome, String tipo, boolean status) {
        super(idUser, senha, nome, tipo, status);
    }
    
}
