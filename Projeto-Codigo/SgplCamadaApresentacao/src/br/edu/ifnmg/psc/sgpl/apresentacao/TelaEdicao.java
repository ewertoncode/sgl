/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Entidade;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;

/**
 *
 * @author Emerson Pereira
 */
public abstract class TelaEdicao<T extends Entidade> extends javax.swing.JInternalFrame{
    
    Repositorio<T> repositorio;
    T entidade;
    
    TelaBusca<T> busca;

    public TelaEdicao() {
        
    }
   
    
    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
        
        
    }

    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    public TelaBusca<T> getBusca() {
        return busca;
    }

    public void setBusca(TelaBusca<T> busca) {
        this.busca = busca;
    }
    
}
