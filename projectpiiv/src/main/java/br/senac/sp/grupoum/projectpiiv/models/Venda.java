package br.senac.sp.grupoum.projectpiiv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Venda {
    private int id;
    private double valorTotal;
    private Date dataVenda;
    private int idCliente;
    private double valorFrete;
    private Endereco endereco;
    private String statusCompra;
    private String metodoPagamento;
    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
    
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

    public Venda(ArrayList<ItemVenda> itensVenda ,double valorTotal, int idCliente) {
        this.itensVenda = itensVenda;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
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

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
}
