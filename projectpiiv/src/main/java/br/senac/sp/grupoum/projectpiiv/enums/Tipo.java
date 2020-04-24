
package br.senac.sp.grupoum.projectpiiv.enums;

public enum Tipo {
    
    ADMIN("admin"),
    ESTOQUISTA("estoquista");

    private final String permissao;

    Tipo(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

}
