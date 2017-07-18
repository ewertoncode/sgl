/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.StatusItem;
import br.edu.ifnmg.psc.sgpl.aplicacao.StatusItemRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class StatusItemDao extends DaoGenerico<StatusItem> implements StatusItemRepositorio{

    public StatusItemDao() throws ClassNotFoundException, SQLException{
        super();     
    }
        
    @Override
    protected String getConsultaInsert() {
        return "insert into status_item(nome) values(?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update status_item set nome = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from status_item where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from status_item where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from status_item";
    }

    @Override
    protected void setBuscaFiltros(StatusItem filtro) {        
        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getNome() != null))
            this.adicionarFiltro("nome", filtro.getNome());
    }

    @Override
    protected void setParametros(PreparedStatement sql, StatusItem obj) {
        
        try{            
            sql.setString(1, obj.getNome());                    
            
            if(obj.getId() > 0)
                sql.setInt(2, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected StatusItem setDados(ResultSet resultado) {
        try{
            StatusItem obj = new StatusItem();
            obj.setId(resultado.getInt("id"));
            obj.setNome(resultado.getString("nome"));            
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
