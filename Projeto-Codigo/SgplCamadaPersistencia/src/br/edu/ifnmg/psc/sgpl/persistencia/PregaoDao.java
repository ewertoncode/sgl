/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.PregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class PregaoDao extends DaoGenerico<Pregao> implements PregaoRepositorio{

    public PregaoDao() throws ClassNotFoundException, SQLException{
        super();
        pedidos = new PedidoDao();
        usuarios = new UsuarioDao();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into pregao(data, diasEntrega, pedido, usuario) values (?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pregao set data = ?, diasEntrega = ?, pedido = ?, usuario = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from pregao where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from pregao where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from pregao";
    }

    @Override
    protected void setBuscaFiltros(Pregao filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getData() != null))
            this.adicionarFiltro("data", filtro.getData());
                
        if(filtro.getDiasEntrega() > 0)
            this.adicionarFiltro("diasEntrega", filtro.getDiasEntrega());
        
        if(filtro.getPedido() != null) 
            this.adicionarFiltro("pedido", filtro.getPedido().getId());
        
        if(filtro.getUsuario() != null) 
            this.adicionarFiltro("usuario", filtro.getUsuario().getId());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Pregao obj) {
        try{            
            sql.setDate(1, (java.sql.Date) obj.getData());            
            sql.setInt(2, obj.getDiasEntrega());  
            if(obj.getPedido() != null) 
                sql.setInt(3, obj.getPedido().getId());
            else
                sql.setNull(3, 0);
            
            if(obj.getUsuario() != null)
                sql.setInt(4, obj.getUsuario().getId());
            else
                sql.setNull(4, 0);
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    PedidoDao pedidos;
    UsuarioDao usuarios;
    
    @Override
    protected Pregao setDados(ResultSet resultado) {
        try{
            Pregao obj = new Pregao();
            obj.setId(resultado.getInt("id"));
            obj.setData(resultado.getDate("data"));
            obj.setDiasEntrega(resultado.getInt("diasEntrega"));  
            if(resultado.getInt("pedido") > 0)
                obj.setPedido(pedidos.Abrir(resultado.getInt("pedido")));
            else 
                obj.setPedido(null);
            
            if(resultado.getInt("usuario") > 0) 
                obj.setUsuario(usuarios.Abrir(resultado.getInt("usuario")));
            else
                obj.setUsuario(null);
               
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private void adicionarFiltro(String data, Date data0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
