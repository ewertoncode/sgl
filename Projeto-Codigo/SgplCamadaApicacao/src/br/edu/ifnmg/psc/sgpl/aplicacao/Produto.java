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
public class Produto implements Entidade{
    
    private int id;
    public String nome;
    private String catmat;
    
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

    public String getCatmat() {
        return catmat;
    }

    public void setCatmat(String catmat) {
        this.catmat = catmat;
    }
    
    
    //Contrutor1
    public Produto() {
    }

    public Produto(int id, String nome, String catmat) {
        this.id = id;
        this.nome = nome;
        this.catmat = catmat;
    }

    @Override
    public String toString() {
        return nome + " - " + catmat + ' ';
    }
    
}
