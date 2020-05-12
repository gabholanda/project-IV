/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import java.text.DecimalFormat;


public class ItemVenda {
    
    private Produto produto;
    private double quantidade;

    public ItemVenda(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public ItemVenda() {}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean qtdPermitida(){
        return this.quantidade < this.produto.getQuantidade();
    }
    
    public double vlrTotalItem(){
        return this.produto.getPreco() * this.quantidade;
    }
    
    public String vlrTotalItemF() {
        DecimalFormat formatador = new DecimalFormat("0.00");
        return formatador.format(this.produto.getPreco() * this.quantidade);
    }
    
}
