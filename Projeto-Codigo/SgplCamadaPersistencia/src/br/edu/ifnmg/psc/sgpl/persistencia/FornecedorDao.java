/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class FornecedorDao extends DaoGenerico<Fornecedor> implements FornecedorRepositorio{
    
    public FornecedorDao() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into fornecedor(razaoSocial, nomeFantasia, cnpj, telefone, email) values (?, ?, ?, ?, ?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update fornecedor set razaoSocial=?, nomeFantasia=?, cnpj=?, telefone=?, email=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from fornecedor where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from fornecedor";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from fornecedor where id=?";
    }

    @Override
    protected void setBuscaFiltros(Fornecedor filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getRazaoSocial() != null) && (!filtro.getRazaoSocial().isEmpty()))
            this.adicionarFiltro("razaoSocial", filtro.getRazaoSocial());
        
        if((filtro.getNomeFantasia() != null) && (!filtro.getNomeFantasia().isEmpty()))
            this.adicionarFiltro("nomeFantasia", filtro.getNomeFantasia());
        
        if((filtro.getCnpj() != null) && (!filtro.getCnpj().isEmpty()))
            this.adicionarFiltro("cnpj", filtro.getCnpj());
        
        if((filtro.getTelefone() != null) && (!filtro.getTelefone().isEmpty()))
            this.adicionarFiltro("telefone", filtro.getTelefone());
        
        if((filtro.getEmail() != null) && (!filtro.getEmail().isEmpty()))
            this.adicionarFiltro("email", filtro.getEmail());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Fornecedor obj) {
         try {
            
            sql.setString(1, obj.getRazaoSocial());
            sql.setString(2, obj.getNomeFantasia());
            sql.setString(3, obj.getCnpj());
            sql.setString(4, obj.getTelefone());
            sql.setString(5, obj.getEmail());
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Fornecedor setDados(ResultSet resultado) {
        try {
            Fornecedor obj = new Fornecedor();
            obj.setId( resultado.getInt("id") );
            obj.setRazaoSocial( resultado.getString("razaoSocial") );
            obj.setNomeFantasia( resultado.getString("nomeFantasia") );
            obj.setCnpj( resultado.getString("cnpj") );
            obj.setEmail( resultado.getString("email") );
            obj.setTelefone( resultado.getString("telefone") );
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
