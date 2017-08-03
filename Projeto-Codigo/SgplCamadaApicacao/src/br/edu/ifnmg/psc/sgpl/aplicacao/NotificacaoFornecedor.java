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
public class NotificacaoFornecedor implements Entidade{
    
    private int id;
    private String descricao;
    private String data;
    private int status;
    private Fornecedor fornecedor;
    private Pregao pregao;
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
    
    //Construtor1
    public NotificacaoFornecedor() {
    }
    
    //Construtor2
    public NotificacaoFornecedor(int id, String descricao, String data, int status, Fornecedor fornecedor, Pregao pregao) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.fornecedor = fornecedor;
        this.pregao = pregao;
    }

    @Override
    public String toString() {
        return "NotificacaoFornecedor: " + "id=" + id + ", descricao=" + descricao + ", data=" + data + ", status=" + status + ", fornecedor=" + fornecedor + ", pregao=" + pregao + ' ';
    }
    
    
    
    
    
    
}
