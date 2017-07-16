/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import br.edu.ifnmg.psc.sgpl.aplicacao.EnderecoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class EnderecoDao extends DaoGenerico<Endereco> implements EnderecoRepositorio{
    
     public EnderecoDao() throws ClassNotFoundException, SQLException {
        super();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into endereco (logradouro, numero, complemento, bairro, cidade, cep, estado, pais) values (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update endereco set logradouro=?, numero=?, complemento=?, bairro=?, cidade=?, cep=?, estado=?, pais=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from endereco where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from endereco where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from endereco";
    }

    @Override
    protected void setBuscaFiltros(Endereco filtro) {
        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getLogradouro()!= null) && (!filtro.getLogradouro().isEmpty()))
            this.adicionarFiltro("logradouro", filtro.getLogradouro());
        
        if((filtro.getNumero() != null) && (!filtro.getNumero().isEmpty()))
            this.adicionarFiltro("numero", filtro.getNumero());
        
        if((filtro.getComplemento()!= null) && (!filtro.getComplemento().isEmpty()))
            this.adicionarFiltro("complemento", filtro.getComplemento());
        
        if((filtro.getBairro()!= null) && (!filtro.getBairro().isEmpty()))
            this.adicionarFiltro("bairro", filtro.getBairro());
        
        if((filtro.getCidade()!= null) && (!filtro.getCidade().isEmpty()))
            this.adicionarFiltro("cidade", filtro.getCidade());
        
        if((filtro.getCep()!= null) && (!filtro.getCep().isEmpty()))
            this.adicionarFiltro("cep", filtro.getCep());
        
        if((filtro.getEstado()!= null) && (!filtro.getEstado().isEmpty()))
            this.adicionarFiltro("estado", filtro.getEstado());
        
        if((filtro.getPais()!= null) && (!filtro.getPais().isEmpty()))
            this.adicionarFiltro("pais", filtro.getPais());
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Endereco obj) {
        try {
            
            sql.setString(1, obj.getLogradouro());
            sql.setString(2, obj.getNumero());
            sql.setString(3, obj.getComplemento());
            sql.setString(4, obj.getBairro());
            sql.setString(5, obj.getCidade());
            sql.setString(6, obj.getCep());
            sql.setString(7, obj.getEstado());
            sql.setString(8, obj.getPais());            
            
            if(obj.getId() > 0)
                sql.setInt(9, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Endereco setDados(ResultSet resultado) {
         try {
            Endereco obj = new Endereco();
            obj.setId( resultado.getInt("id") );
            obj.setLogradouro(resultado.getString("logradouro") );
            obj.setNumero(resultado.getString("numero") );
            obj.setComplemento(resultado.getString("complento") );
            obj.setBairro(resultado.getString("bairro") );
            obj.setCidade(resultado.getString("cidade") );
            obj.setCep(resultado.getString("cep") );
            obj.setEstado(resultado.getString("estado") );
            obj.setPais(resultado.getString("pais") );            
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
