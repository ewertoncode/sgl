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
        if(nome == null || nome.length() < 1)
            throw new ViolacaoRegraDeNegocioException("O nome do setor deve ter no mínimo 1 caracter!");
        this.nome = nome;
    }        
    
    //Contrutor1
    public Setor() {
    }
    
    
    //Construtor2
    public Setor(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    //Fazer o hashCode() e equals() ????????????
        
}
