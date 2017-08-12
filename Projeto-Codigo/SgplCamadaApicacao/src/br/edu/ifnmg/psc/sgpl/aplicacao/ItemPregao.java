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
public class ItemPregao implements Entidade{
    
    private int id;
    private double quantidade;
    private double valorReferencia;
    private Pregao pregao;
    private Produto produto;
    private Fornecedor forncedor;
    private StatusPregaoItem statusItem;
    
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

    public double getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(double valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public Pregao getPregao() {
        return pregao;
    }

    public void setPregao(Pregao pregao) {
        this.pregao = pregao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getForncedor() {
        return forncedor;
    }

    public void setForncedor(Fornecedor forncedor) {
        this.forncedor = forncedor;
    }

    public StatusPregaoItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusPregaoItem statusItem) {
        this.statusItem = statusItem;
    }
    
    //Construtor1
    public ItemPregao() {
    }
    
    //Contrutor2
    public ItemPregao(int id, double quantidade, double valorReferencia, Pregao pregao, Produto produto, Fornecedor forncedor, StatusPregaoItem statusItem) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorReferencia = valorReferencia;
        this.pregao = pregao;
        this.produto = produto;
        this.forncedor = forncedor;
        this.statusItem = statusItem;
    }

    @Override
    public String toString() {
        return "ItemPregao: " + "id=" + id + ", quantidade=" + quantidade + ", valorReferencia=" + valorReferencia + ", pregao=" + pregao + ", produto=" + produto + ", forncedor=" + forncedor + ", statusItem=" + statusItem + ' ';
    }
    
    
    
    
    
    
    
    
}
