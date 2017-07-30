/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

import java.util.Date;
import java.util.Objects;

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
    private StatusPregao status;
    
   
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

    public StatusPregao getStatus() {
        return status;
    }

    public void setStatus(StatusPregao status) {
        this.status = status;
    }
    

    public Pregao() {
    }

    public Pregao(int id, Date data, int diasEntrega, Pedido pedido, Usuario usuario, StatusPregao status) {
        this.id = id;
        this.data = data;
        this.diasEntrega = diasEntrega;
        this.pedido = pedido;
        this.usuario = usuario;
        this.status = status;
    }

    @Override
    public String toString() {
        return ""+this.id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + this.diasEntrega;
        hash = 97 * hash + Objects.hashCode(this.pedido);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregao other = (Pregao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.diasEntrega != other.diasEntrega) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }
    
    
    
}
