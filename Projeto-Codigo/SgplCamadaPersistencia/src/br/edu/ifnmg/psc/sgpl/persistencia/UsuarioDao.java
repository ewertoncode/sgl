/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
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
public class UsuarioDao extends DaoGenerico<Usuario> implements UsuarioRepositorio{
    
    public UsuarioDao() throws ClassNotFoundException, SQLException{
        super();
    }
    
    @Override
    protected String getConsultaInsert(){
        return "insert into Usuario(nome, email, senha, setor, endereco) values (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getConsultaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getConsultaAbrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getConsultaBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setBuscaFiltros(Usuario filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setParametros(PreparedStatement sql, Usuario obj) {
        try{            
            sql.setString(1, obj.getNome());            
            sql.setString(2, obj.getEmail());            
            sql.setString(3, obj.getSenha());
            sql.setInt(4, obj.getSetor().getId());
            sql.setInt(5, obj.getEndereco().getId());
            
            //if(obj.getId() > 0)
                //sql.setInt(5, obj.getId());
            
        }catch(Exception e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected Usuario setDados(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario Abrir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> Buscar(Usuario filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Apagar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    

}
