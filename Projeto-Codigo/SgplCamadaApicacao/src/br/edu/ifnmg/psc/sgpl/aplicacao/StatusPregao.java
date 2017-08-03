/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

/**
 *
 * @author ewertoncardoso
 */
public enum StatusPregao {

    ELABORANDO_EDITAL(1,"Elaborando edital"),
    PREGAO_ABERTO(2, "Pregao Aberto"),
    PREGAO_FINALIZADO(3, "Pregão Finalizado"),
    AGUARDANDO_ENTREGA(4, "Aguardando entrega");
    
    private int id;
    private String descricao;
    
    private StatusPregao(int id, String desc){
        this.id = id;
        this.descricao = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    @Override
    public String toString() {
        return descricao;
    }
    
    public static StatusPregao Abrir(int id){
        for(StatusPregao t : StatusPregao.values())
            if(id == t.getId())
                return t;
        return null;
    }
    
}
