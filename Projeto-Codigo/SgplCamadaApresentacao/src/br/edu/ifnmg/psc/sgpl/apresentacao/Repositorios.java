/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.FornecedorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ProdutoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.SetorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.UsuarioDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class Repositorios { 
    
    static UsuarioRepositorio usuarioDao = null;
    
    public static UsuarioRepositorio getUsuarioRepositorio(){
        if(usuarioDao == null)
            try {
                usuarioDao = new UsuarioDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return usuarioDao;
    }
    
    static FornecedorRepositorio fornecedorDao = null;
    
    public static FornecedorRepositorio getFornecedorRepositorio(){
        if(fornecedorDao == null)
            try {
                fornecedorDao = new FornecedorDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fornecedorDao;
    }
    
    static ProdutoRepositorio produtoDao = null;
    
    public static ProdutoRepositorio getProdutoRepositorio(){
        if(produtoDao == null)
            try {
                produtoDao = new ProdutoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return produtoDao;
    }
    
     static SetorRepositorio setorDao = null;
    
    public static SetorRepositorio getSetorRepositorio(){
        if(setorDao == null)
            try {
                setorDao = new SetorDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return setorDao;
    }
    
    
}

 