/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenho;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenhoRepositorio;
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
public class NotaEmpenhoDao extends DaoGenerico<NotaEmpenho> implements NotaEmpenhoRepositorio{

    public NotaEmpenhoDao() throws ClassNotFoundException, SQLException{
        super();
        fornecedores = new FornecedorDao();
        pregoes = new PregaoDao();
        usuarios = new UsuarioDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into nota_empenho(data, valor, status, pregao, fornecedor, usuario) values (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update nota_empenho set data = ?, valor = ?, status = ?, fornecedor = ?, pregao = ?, usuario = ? where id = ?";
    } 

    @Override
    protected String getConsultaDelete() {
        return "delete from nota_empenho where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from nota_empenho where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from nota_empenho";
    }

    @Override
    protected void setBuscaFiltros(NotaEmpenho filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getData() != null))
            this.adicionarFiltro("data", filtro.getData());        
        /*
        if(filtro.getValor())
            this.adicionarFiltro("valor", filtro.getValor());
        */
        if(filtro.getStatus()!= null)
            this.adicionarFiltro("status", filtro.getStatus());
        /*
        if(filtro.getFornecedor()> 0 )
            this.adicionarFiltro("fornecedor", filtro.getFornecedor());
        
        if(filtro.getPregao()> 0 )
            this.adicionarFiltro("pregao", filtro.getPregao());
        
        if(filtro.getUsuario()> 0 )
            this.adicionarFiltro("usuario", filtro.getUsuario());
        */
    }

    @Override
    protected void setParametros(PreparedStatement sql, NotaEmpenho obj) {
        try{            
            sql.setString(1, obj.getData());            
            sql.setDouble(2, obj.getValor());            
            sql.setString(3, obj.getStatus());
            sql.setInt(4, obj.getFornecedor().getId());
            sql.setInt(5, obj.getPregao().getId());
            sql.setInt(6, obj.getUsuario().getId());
            
            if(obj.getId() > 0)
                sql.setInt(7, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
     FornecedorDao fornecedores;
     PregaoDao pregoes;
     UsuarioDao usuarios;
     
    @Override
    protected NotaEmpenho setDados(ResultSet resultado) {
        try{
            NotaEmpenho obj = new NotaEmpenho();
            obj.setId(resultado.getInt("id"));
            obj.setValor(resultado.getDouble("valor"));
            obj.setStatus(resultado.getString("status"));                     
            obj.setFornecedor(fornecedores.Abrir(resultado.getInt("fornecedor")));
            obj.setPregao(pregoes.Abrir(resultado.getInt("pregao")));
            obj.setUsuario(usuarios.Abrir(resultado.getInt("usuario")));
                        
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
