/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

/**
 *
 * @author haw
 */
public class NotaEmpenho implements Entidade{
    
    private int id;
    private String data;
    private double valor;
    private String status;
    private Fornecedor fornecedor;
    private Pregao pregao;
    private Usuario usuario;

    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Pregao getPregao() {
        return pregao;
    }

    public void setPregao(Pregao pregao) {
        this.pregao = pregao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    //Construtor1
    public NotaEmpenho() {
    }
    
    //Construtor2
    public NotaEmpenho(int id, String data, double valor, String status, Fornecedor fornecedor, Pregao pregao, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.status = status;
        this.fornecedor = fornecedor;
        this.pregao = pregao;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "NotaEmpenho: " + "id=" + id + ", data=" + data + ", valor=" + valor + ", status=" + status + ", fornecedor=" + fornecedor + ", pregao=" + pregao + ", usuario=" + usuario + ' ';
    }
    
    
    
    
    
    
}
