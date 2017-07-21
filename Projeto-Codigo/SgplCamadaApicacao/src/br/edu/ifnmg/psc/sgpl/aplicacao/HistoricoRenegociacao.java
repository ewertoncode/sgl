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
public class HistoricoRenegociacao implements Entidade{
    
    private int id;
    private String descricao;
    private String data;
    private Pregao pregao;
    private Fornecedor fornecedor;
    private Usuario usuario;
    
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

    public void setDescricao(String Descricao) {
        this.descricao = Descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String Data) {
        this.data = Data;
    }

    public Pregao getPregao() {
        return pregao;
    }

    public void setPregao(Pregao Pregao) {
        this.pregao = Pregao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //Construtor1
    public HistoricoRenegociacao() {
    }
    
    //Construtor2
    public HistoricoRenegociacao(int id, String Descricao, String Data, Pregao Pregao, Fornecedor fornecedor, Usuario usuario) {
        this.id = id;
        this.descricao = Descricao;
        this.data = Data;
        this.pregao = Pregao;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "HistoricoRenegociacao: " + "id=" + id + ", Descricao=" + descricao + ", Data=" + data + ", Pregao=" + pregao + ", fornecedor=" + fornecedor + ", usuario=" + usuario + ' ';
    }
    
    
    
    
    
    
    
    
    
    
}
