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
public enum StatusPregaoItem {
    
    LICITANDO(1,"Licitando item"),
    LICITADO(2, "Produto licitado"),
    EMPENHADO(3, "Emitido nota de empenho"),
    ENTREGUE(4, "Produto entregue"),
    ATRASADO(5, "Atrasado");
    
    private int id;
    private String descricao;
    
    private StatusPregaoItem(int id, String desc){
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
    
    public static StatusPregaoItem Abrir(int id){
        for(StatusPregaoItem t : StatusPregaoItem.values())
            if(id == t.getId())
                return t;
        return null;
    }
}
