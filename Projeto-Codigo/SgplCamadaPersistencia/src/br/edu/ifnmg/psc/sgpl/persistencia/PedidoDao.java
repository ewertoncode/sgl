/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class PedidoDao extends DaoGenerico<Pedido> implements PedidoRepositorio{
    
    private UsuarioDao usuario;
    
    public PedidoDao() throws ClassNotFoundException, SQLException {
        super();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into pedido(data, usuario) values(?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pedido set usuario=?, data=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from pedido where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from pedido where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from pedido";
    }

    @Override
    protected void setBuscaFiltros(Pedido filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getData()!= null))
            this.adicionarFiltro("data", filtro.getData());
                
        if(filtro.getUsuario()!= null)
            this.adicionarFiltro("usuario", filtro.getUsuario().getId());
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Pedido obj) {
        try{            
            sql.setString(1, obj.getData());            
            sql.setInt(2, obj.getUsuario().getId());                        
            
            if(obj.getId() > 0)
                sql.setInt(3, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected Pedido setDados(ResultSet resultado) {
        try{
            Pedido obj = new Pedido();
            obj.setId(resultado.getInt("id"));
            obj.setData(resultado.getString("data"));
            obj.setUsuario(usuario.Abrir(resultado.getInt("usuario")));                                    
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
