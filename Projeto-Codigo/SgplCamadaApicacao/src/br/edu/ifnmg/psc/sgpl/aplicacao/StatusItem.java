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
public class StatusItem implements Entidade{
    
    private int id;
    private String nome;
    
    @Override
    public int getId() {        
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    //Construtor1 
    public StatusItem() {
    }
    
    //Construtor1 
    public StatusItem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "StatusItem: " + "id=" + id + ", nome=" + nome + ' ';
    }
    
    
    
    
    
    
    
}
