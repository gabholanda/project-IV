/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

public class Usuario {

    private String email;
    private String senha;
    private int status; 

    public Usuario() {
    }

    public Usuario(String email, String senha) {

        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha, String tipo) {

        this.email = email;
        this.senha = senha;

    }

    public Usuario(String senha) {
        this.senha = senha;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
      public boolean verificarFuncao(String funcao) {
        return this.getClass().getSimpleName().equals(funcao);
    }
    
      public String montarUrl() {
        String funcao = this.getClass().getSimpleName();
        
         return "/" + funcao.toLowerCase();
    }

}
