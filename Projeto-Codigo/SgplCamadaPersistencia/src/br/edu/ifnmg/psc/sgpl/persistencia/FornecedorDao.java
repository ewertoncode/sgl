/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class FornecedorDao extends DaoGenerico<Fornecedor> implements FornecedorRepositorio{
    
    public FornecedorDao() throws ClassNotFoundException, SQLException {
        super();
        enderecos = new EnderecoDao();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into fornecedor(razaoSocial, nomeFantasia, cnpj, telefone, email, endereco) values (?, ?, ?, ?, ?, ?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update fornecedor set razaoSocial=?, nomeFantasia=?, cnpj=?, telefone=?, email=?, endereco=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from fornecedor where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from fornecedor where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from fornecedor";
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
             
        if(filtro.getEndereco()!= null) 
            this.adicionarFiltro("endereco", filtro.getEndereco().getId());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Fornecedor obj) {
         try {
            
            sql.setString(1, obj.getRazaoSocial());
            sql.setString(2, obj.getNomeFantasia());
            sql.setString(3, obj.getCnpj());
            sql.setString(4, obj.getTelefone());
            sql.setString(5, obj.getEmail());
            sql.setInt(6, obj.getEndereco().getId());
            
            if(obj.getId() > 0)
                sql.setInt(7, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    EnderecoDao enderecos;
    
    @Override
    protected Fornecedor setDados(ResultSet resultado) {
        try {
            Fornecedor obj = new Fornecedor();
            obj.setId( resultado.getInt("id") );
            obj.setRazaoSocial( resultado.getString("razaoSocial") );
            obj.setNomeFantasia( resultado.getString("nomeFantasia") );
            obj.setCnpj( resultado.getString("cnpj") );
            obj.setEmail( resultado.getString("email") );
            obj.setTelefone( resultado.getString("telefone"));            
            obj.setEndereco(enderecos.Abrir(resultado.getInt("endereco")));
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean Salvar(Fornecedor obj){
        if(obj.getEndereco() != null && obj.getEndereco().getId() == 0)
            if(this.enderecos.Salvar(obj.getEndereco())){
                List<Endereco> tmp = this.enderecos.Buscar(obj.getEndereco());
                obj.setEndereco(tmp.get(0));
            }
        return super.Salvar(obj);
    }

}