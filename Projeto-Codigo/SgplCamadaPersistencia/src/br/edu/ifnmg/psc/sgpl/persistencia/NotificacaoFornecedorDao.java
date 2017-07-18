/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.NotificacaoFornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotificacaoFornecedorRepositorio;
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
public class NotificacaoFornecedorDao extends DaoGenerico<NotificacaoFornecedor> implements NotificacaoFornecedorRepositorio{
    
    public NotificacaoFornecedorDao() throws ClassNotFoundException, SQLException{
        super();
        fornecedores = new FornecedorDao();
        pregoes = new PregaoDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into notificacao_fornecedor(descricao, data, status, fornecedor, pregao) values(?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update notificacao_fornecedor set descricao = ?, data = ?, status = ?, fornecedor = ?, pregao = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from notificacao_fornecedor where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from notificacao_fornecedor where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from notificacao_fornecedor";
    }

    @Override
    protected void setBuscaFiltros(NotificacaoFornecedor filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getDescricao()!= null))
            this.adicionarFiltro("descricao", filtro.getDescricao());
         
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, NotificacaoFornecedor obj) {
        try{            
            sql.setString(1, obj.getDescricao());            
            sql.setString(2, obj.getData());            
            sql.setInt(3, obj.getStatus());            
            sql.setInt(4, obj.getFornecedor().getId());
            sql.setInt(5, obj.getPregao().getId());
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    FornecedorDao fornecedores;
    PregaoDao pregoes;
    
    @Override
    protected NotificacaoFornecedor setDados(ResultSet resultado) {
        try{
            NotificacaoFornecedor obj = new NotificacaoFornecedor();
            obj.setId(resultado.getInt("id"));
            obj.setDescricao(resultado.getString("descricao"));
            obj.setData(resultado.getString("data"));                     
            obj.setStatus(resultado.getInt("status"));                                             
            obj.setFornecedor(fornecedores.Abrir(resultado.getInt("fornecedor")));
            obj.setPregao(pregoes.Abrir(resultado.getInt("pregao")));
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
