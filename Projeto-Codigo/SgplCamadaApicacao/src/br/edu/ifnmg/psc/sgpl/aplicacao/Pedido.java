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
public class Pedido implements Entidade{
    
    private int id;
    private String data; 
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public Pedido(int id, String data, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return id + " - " + data + " - " + usuario + ' ';
    }

    public void setData(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
        
    
}
