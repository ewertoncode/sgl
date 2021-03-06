/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenhoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.PregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.EnderecoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.FornecedorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ItemPregaoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ItemPedidoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.NotaEmpenhoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PedidoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PregaoDao;
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
public class Repositorios{ 
    
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
    
    static EnderecoRepositorio enderecoDao = null;
    
    public static EnderecoRepositorio getEnderecoRepositorio(){
        if(enderecoDao == null)
            try {
                enderecoDao = new EnderecoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return enderecoDao;
    }
    
    static PedidoRepositorio pedidoDao = null;
    
    public static PedidoRepositorio getPedidoRepositorio(){
        if(pedidoDao == null)
            try {
                pedidoDao = new PedidoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return pedidoDao;
    }
    

    static ItemPedidoRepositorio itemPedidoDao = null;
    
    public static ItemPedidoRepositorio getItemPedidoRepositorio(){
        if(itemPedidoDao == null)
            try {
                itemPedidoDao = new ItemPedidoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return itemPedidoDao;
    }
                
    static PregaoRepositorio pregaoDao = null;
    
    public static PregaoRepositorio getPregaoRepositorio(){
        if(pregaoDao == null)
            try {
                pregaoDao = new PregaoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return pregaoDao;

    }
    
    static ItemPregaoRepositorio itemPregaoDao = null;
    
    public static ItemPregaoRepositorio getItemPregaoRepositorio(){
        if(produtoDao == null)
            try {
                itemPregaoDao = new ItemPregaoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return itemPregaoDao;
    }
    
    static NotaEmpenhoRepositorio notaEmpenhoDao = null;
    
    public static NotaEmpenhoRepositorio getNotaEmpenhoRepositorio(){
        if(notaEmpenhoDao == null)
            try {
                notaEmpenhoDao = new NotaEmpenhoDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return notaEmpenhoDao;
    }
    
}        
 