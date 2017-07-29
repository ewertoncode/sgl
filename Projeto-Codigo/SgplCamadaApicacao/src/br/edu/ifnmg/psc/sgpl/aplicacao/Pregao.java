/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

import java.util.Date;

/**
 *
 * @author Emerson Pereira
 */
public class Pregao implements Entidade{        
    
    private int id;
    private Date data;
    private int diasEntrega;
    private Pedido pedido;
    private Usuario usuario;

    public Pregao(int i, Date data, Pedido pedido, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(int diasEntrega) {
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

    public Pregao(int id, Date data, int diasEntrega, Pedido pedido, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.diasEntrega = diasEntrega;
        this.pedido = pedido;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return ""+this.id;
    }
    
    
    
}
