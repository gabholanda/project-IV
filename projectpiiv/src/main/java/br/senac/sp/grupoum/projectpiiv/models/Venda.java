/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.grupoum.projectpiiv.models;

import java.util.Date;


public class Venda {
    private int id;
    private double valorTotal;
    private Date dataVenda;
    private int idCliente;
    private String statusCompra;
    private String metodoPagamento;
    
    public Venda() {}
    
    public Venda(int id, double valorTotal, Date dataVenda, 
                 int idCliente, String statusCompra, String metodoPagamento) {
        
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.statusCompra = statusCompra;
        this.metodoPagamento = metodoPagamento;
    }
    
    public Venda(double valorTotal, Date dataVenda, 
                 int idCliente, String statusCompra, String metodoPagamento) {
        
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.statusCompra = statusCompra;
        this.metodoPagamento = metodoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    
}
