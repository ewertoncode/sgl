/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
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
public class ProdutoDao extends DaoGenerico<Produto> implements ProdutoRepositorio{
    
    public ProdutoDao() throws ClassNotFoundException, SQLException {
        super();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into produto (nome, catmat) values (?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update produto set nome=?, catmat=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from produto where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from produto where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from produto";
    }

    @Override
    protected void setBuscaFiltros(Produto filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if((filtro.getNome() != null))
            this.adicionarFiltro("nome", filtro.getNome());        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Produto obj) {
        try{            
            sql.setString(1, obj.getNome());                        
            
            if(obj.getId() > 0)
                sql.setInt(2, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected Produto setDados(ResultSet resultado) {
        try{
            Produto obj = new Produto();
            obj.setId(resultado.getInt("id"));
            obj.setNome(resultado.getString("nome")); 
            obj.setCatmat(resultado.getString("catmat")); 
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    

}
