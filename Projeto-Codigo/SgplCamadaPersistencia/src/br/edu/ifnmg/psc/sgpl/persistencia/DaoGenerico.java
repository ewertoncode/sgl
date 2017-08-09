/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Entidade;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */

public abstract class DaoGenerico<T extends Entidade> implements Repositorio<T>{
    
    protected Connection conexao;
    
    public DaoGenerico() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgpl","root", "root");
        
        System.out.print(conexao);
    }
    
    private String where = "";
    
    protected abstract String getConsultaInsert();
    protected abstract String getConsultaUpdate();
    protected abstract String getConsultaDelete();
    protected abstract String getConsultaAbrir();
    protected abstract String getConsultaBuscar();    
    protected abstract void setBuscaFiltros(T filtro);    
    protected abstract void setParametros(PreparedStatement sql, T obj);
    protected abstract T setDados(ResultSet resultado);
       
    @Override
    public boolean Salvar(T obj){
        try{
            PreparedStatement sql = null;
            
            if(obj.getId() == 0){                
                sql = conexao.prepareStatement(getConsultaInsert());                                                            
            }else{                
                sql = conexao.prepareStatement(getConsultaUpdate());                
            }
            
            setParametros(sql, obj);            
             
            if(sql.executeUpdate() > 0)
                return true;
            else                
                return false;            
            
        }catch(Exception e){ 
            System.out.println(e.getMessage());
            return false;
        }        
    }
    
    @Override
    public boolean Apagar(T obj){
        
        try {        
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaDelete());
                                
            sql.setInt(1, obj.getId());

            if (sql.executeUpdate() > 0) {
                System.out.println(sql);    
                obj = null;
                return true;
            } else {                  
                System.out.println(sql);
                return false;
            }                       
        } catch (SQLException ex) {
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }                
    }
        
    @Override
    public T Abrir(int id){
        try{
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaAbrir());
            
            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();            
            if(resultado.next())                
                return this.setDados(resultado);
            else
                return null;
            
        }catch(SQLException e){
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return null;
    }  
    
    protected DaoGenerico<T> adicionarFiltro(String campo, String valor){
        if(where.length() > 0)
            where += " and ";
        
        where += campo + " = '" + valor + "'";
        
        return this;                
    }
    
    protected DaoGenerico<T> adicionarFiltro(String campo, int valor){
        if(where.length() > 0)
            where += " and ";
        
        where += campo + " = " + Integer.toString(valor);
        
        return this;    
    }
        
    @Override
    public List<T> Buscar(T filtro){

        List<T> lista = new ArrayList<>();
        
        try{
           if(filtro != null)
                this.setBuscaFiltros(filtro);
            
            String sqlfinal = this.getConsultaBuscar();
            
            if(! where.isEmpty())
                sqlfinal += " where " + where;
                        
            PreparedStatement sql = conexao.prepareStatement(sqlfinal );
                       
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next())
                lista.add( this.setDados(resultado) );
            
            this.where = "";
            
            return lista;
            
        }catch(Exception e){
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, e);
        }
                
        return null;
    }   
    
}
