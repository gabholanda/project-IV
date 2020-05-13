package br.senac.sp.grupoum.projectpiiv.models;

/**
 *
 * @author Pablo de Oliveira
 */
public class Cliente {

    private int idCliente;
    private String nome;
    private String sobreNome;
    private String cpf;

    private String email;
    private String senha;

    public Cliente(int idCliente, String nome, String sobreNome, String cpf, String email, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
  
        this.email = email;
        this.senha = senha;
    }

    public Cliente(String nome, String sobreNome, String cpf, String email, String senha) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;

        this.email = email;
        this.senha = senha;
    }

    public Cliente(String nome, String sobreNome, String cpf, String email) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;

        this.email = email;
    }

    public Cliente() {
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
 
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

}
