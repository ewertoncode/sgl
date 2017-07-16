/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
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
public class UsuarioDao extends DaoGenerico<Usuario> implements UsuarioRepositorio{
    
    public UsuarioDao() throws ClassNotFoundException, SQLException{
        super();
    }
    
    @Override
    protected String getConsultaInsert(){
        return "insert into usuario(nome, email, senha, setor, endereco) values (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update usuario set nome = ?, email = ?, senha = ?, setor = ?, endereco = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from usuario where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from usuario where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from usuario";
    }

    @Override
    protected void setBuscaFiltros(Usuario filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getNome() != null))
            this.adicionarFiltro("nome", filtro.getNome());
        
        //refazer aqui
        if(filtro.getEmail() != null)
            this.adicionarFiltro("email", filtro.getEmail());
        
        if(filtro.getSenha() != null)
            this.adicionarFiltro("senha", filtro.getSenha());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Usuario obj) {
        try{            
            sql.setString(1, obj.getNome());            
            sql.setString(2, obj.getEmail());            
            sql.setString(3, obj.getSenha());
            sql.setInt(4, obj.getSetor().getId());
            sql.setInt(5, obj.getEndereco().getId());
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected Usuario setDados(ResultSet resultado) {
        try{
            Usuario obj = new Usuario();
            obj.setId(resultado.getInt("id"));
            obj.setNome(resultado.getString("nome"));
            obj.setEmail(resultado.getString("email"));
            obj.getSetor().setId(resultado.getInt("setor"));
            obj.getEndereco().setId(resultado.getInt("endereco"));
            
            return obj;
            
        }catch(ViolacaoRegraDeNegocioException | SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
