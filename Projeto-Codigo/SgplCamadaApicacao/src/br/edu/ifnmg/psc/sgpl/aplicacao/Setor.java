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
public class Setor implements Entidade{
    
    private int id;
    private String nome;
    
    @Override
    public int getId(){
        return this.id;
    }
    
    @Override
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    //Regra de Negócio UC1.1/RN1
    public void setNome(String nome) throws ViolacaoRegraDeNegocioException {        
        this.nome = nome;
    }        
    
    //Contrutor1
    public Setor() {
    }
    
    @Override
    public String toString(){

        return id + " - " + nome + " ";

    }
    

        
}
