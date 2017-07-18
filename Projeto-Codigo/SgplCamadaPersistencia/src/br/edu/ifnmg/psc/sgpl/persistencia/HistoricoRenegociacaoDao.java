/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.HistoricoRenegociacao;
import br.edu.ifnmg.psc.sgpl.aplicacao.HistoricoRenegociacaoRepositorio;
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
public class HistoricoRenegociacaoDao extends DaoGenerico<HistoricoRenegociacao> implements HistoricoRenegociacaoRepositorio{
    
    public HistoricoRenegociacaoDao() throws ClassNotFoundException, SQLException{
        super();
        pregoes = new PregaoDao();
        fornecedores = new FornecedorDao();
        usuarios = new UsuarioDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into historico_renegociacao(descricao, data, pregao, fornecedor, usuario) values (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update historico_renegociacao set descricao = ?, data = ?, pregao = ?, fornecedor = ?, usuario = ? where id =?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from historico_renegociacao where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from historico_renegociacao where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from historico_renegociacao";
    }

    @Override
    protected void setBuscaFiltros(HistoricoRenegociacao filtro) {
        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getDescricao()!= null))
            this.adicionarFiltro("descricao", filtro.getDescricao());
        
        if((filtro.getData() != null))
            this.adicionarFiltro("data", filtro.getData());
                        
    }

    @Override
    protected void setParametros(PreparedStatement sql, HistoricoRenegociacao obj) {
        try{            
            sql.setString(1, obj.getDescricao());            
            sql.setString(2, obj.getData());                        
            sql.setInt(3, obj.getPregao().getId());
            sql.setInt(4, obj.getFornecedor().getId());
            sql.setInt(5, obj.getUsuario().getId());
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    FornecedorDao fornecedores;
    PregaoDao pregoes;
    UsuarioDao usuarios;
    
    @Override
    protected HistoricoRenegociacao setDados(ResultSet resultado) {
         try{
            HistoricoRenegociacao obj = new HistoricoRenegociacao();
            obj.setId(resultado.getInt("id"));
            obj.setDescricao(resultado.getString("descricao"));
            obj.setData(resultado.getString("data"));
            obj.setPregao(pregoes.Abrir(resultado.getInt("pregao")));
            obj.setFornecedor(fornecedores.Abrir(resultado.getInt("fornecedor")));
            obj.setUsuario(usuarios.Abrir(resultado.getInt("usuario")));
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
