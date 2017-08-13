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
public class NotaEmpenho implements Entidade{
    
    private int id;
    private int numeroNota;
    private ItemPregao itemPregao;  
    private double valor;
    private boolean pago;
    private Date dataPagamento;

    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public ItemPregao getItemPregao() {
        return itemPregao;
    }

    public void setItemPregao(ItemPregao itemPregao) {
        this.itemPregao = itemPregao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
    //Construtor1
    public NotaEmpenho() {
    
       this.pago = false;
    
    }
    
   

    @Override
    public String toString() {
        return "nº" + numeroNota;
    }

}
