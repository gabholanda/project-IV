/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Produto {

    int id;
    String nome;
    String descricao;
    String tipo;
    ArrayList<String> troll = new ArrayList<>();
    double preco;
    double quantidade;

    public Produto() {

    }

    public Produto(String nome, String descricao, String tipo, double preco,
            double quantidade) {

        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, String descricao, String tipo, double preco,
            double quantidade) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getTroll() {
        return troll;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
