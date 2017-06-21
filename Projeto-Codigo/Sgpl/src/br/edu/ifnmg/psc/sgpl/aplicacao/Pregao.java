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
public class Pregao implements Entidade{        
    
    private int id;
    private String data;
    private String diasEntrega;
    private Pedido pedido;
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

    public String getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(String diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

    public Pregao() {
    }

    public Pregao(int id, String data, String diasEntrega, Pedido pedido, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.diasEntrega = diasEntrega;
        this.pedido = pedido;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pregao: " + "id=" + id + ", data=" + data + ", diasEntrega=" + diasEntrega + ", pedido=" + pedido + ", usuario=" + usuario + '}';
    }
    
    
    
}
