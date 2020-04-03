/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.enums;

public enum Tipo {
    
    ADMIN("ADMIN"),
    ESTOQUISTA("ESTOQUISTA");

    private final String permissao;

    Tipo(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

}
