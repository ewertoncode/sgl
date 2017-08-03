/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

/**
 *
 * @author Emerson Pereira
 */
public class ItemPedido implements Entidade{
    
    private int id;
    private double quantidade;
    private Fornecedor fornecedor1;
    private double valorFornecedor1;
    private Fornecedor fornecedor2;
    private double valorFornecedor2;
    private Fornecedor fornecedor3;
    private double valorFornecedor3;    
    private Pedido pedido;
    private Produto produto;

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor1() {
        return fornecedor1;
    }

    public void setFornecedor1(Fornecedor fornecedor1) {
        this.fornecedor1 = fornecedor1;
    }

    public double getValorFornecedor1() {
        return valorFornecedor1;
    }

    public void setValorFornecedor1(double valorFornecedor1) {
        this.valorFornecedor1 = valorFornecedor1;
    }

    public Fornecedor getFornecedor2() {
        return fornecedor2;
    }

    public void setFornecedor2(Fornecedor fornecedor2) {
        this.fornecedor2 = fornecedor2;
    }

    public double getValorFornecedor2() {
        return valorFornecedor2;
    }

    public void setValorFornecedor2(double valorFornecedor2) {
        this.valorFornecedor2 = valorFornecedor2;
    }

    public Fornecedor getFornecedor3() {
        return fornecedor3;
    }

    public void setFornecedor3(Fornecedor fornecedor3) {
        this.fornecedor3 = fornecedor3;
    }

    public double getValorFornecedor3() {
        return valorFornecedor3;
    }

    public void setValorFornecedor3(double valorFornecedor3) {
        this.valorFornecedor3 = valorFornecedor3;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    //Construtor1
    public ItemPedido() {
    }
    
    //Construtor2
    public ItemPedido(int id, double quantidade, Fornecedor fornecedor1, double valorFornecedor1, Fornecedor fornecedor2, double valorFornecedor2, Fornecedor fornecedor3, double valorFornecedor3, Pedido pedido, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.fornecedor1 = fornecedor1;
        this.valorFornecedor1 = valorFornecedor1;
        this.fornecedor2 = fornecedor2;
        this.valorFornecedor2 = valorFornecedor2;
        this.fornecedor3 = fornecedor3;
        this.valorFornecedor3 = valorFornecedor3;
        this.pedido = pedido;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "ItemPedido: " + "id=" + id + ", quantidade=" + quantidade + ", fornecedor1=" + fornecedor1 + ", valorFornecedor1=" + valorFornecedor1 + ", fornecedor2=" + fornecedor2 + ", valorFornecedor2=" + valorFornecedor2 + ", fornecedor3=" + fornecedor3 + ", valorFornecedor3=" + valorFornecedor3 + ", pedido=" + pedido + ", produto=" + produto + ' ';
    }
    
    
    
   
    
    
    
    
    
    
}
