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
    private String endereco;
    private String enderecoEntrega;
    private String cep;
    private String email;
    private String senha;

    public Cliente(int idCliente, String nome, String sobreNome, String cpf, String endereco, String enderecoEntrega, String cep, String email, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.enderecoEntrega = enderecoEntrega;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(String nome, String sobreNome, String cpf, String endereco, String enderecoEntrega, String cep, String email, String senha) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.enderecoEntrega = enderecoEntrega;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(String nome, String sobreNome, String cpf, String endereco, String enderecoEntrega, String cep, String email) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.enderecoEntrega = enderecoEntrega;
        this.cep = cep;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
