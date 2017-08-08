/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregaoRepositorio;
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
public class ItemPregaoDao extends DaoGenerico<ItemPregao> implements ItemPregaoRepositorio{
    
    public ItemPregaoDao() throws ClassNotFoundException, SQLException{
        super();
        pregoes = new PregaoDao();
        produtos = new ProdutoDao();
        fornecedores = new FornecedorDao();
        statusItens = new StatusItemDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into pregao_itens(produto_id, qtd, pregao_id, valor_referencia, fornecedor_id, status_item) values(?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update item_pregao set quantidade = ?, valorReferencia = ?, pregao = ?, produto = ?, fornecedor = ?, statusItem = ? where id =?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from item_pregao where id = ?";
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
    protected void setBuscaFiltros(ItemPregao filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
    }

    @Override
    protected void setParametros(PreparedStatement sql, ItemPregao obj) {
        try{            
            sql.setDouble(1, obj.getProduto().getId());  
            sql.setInt(2, (int)obj.getQuantidade()); 
            if(obj.getPregao() != null)
                sql.setInt(3, obj.getPregao().getId());   
            else
                sql.setNull(3, 0);   
            
            sql.setDouble(4, obj.getValorReferencia());
            if(obj.getForncedor() != null)
                sql.setInt(5, obj.getForncedor().getId());
            else
                sql.setNull(5, 0);
            
            if(obj.getStatusItem() != null)
                sql.setInt(6, obj.getStatusItem().getId());
            else
                sql.setNull(6, 0);
            
            if(obj.getId() > 0)
                sql.setInt(7, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    PregaoDao pregoes;
    ProdutoDao produtos;
    FornecedorDao fornecedores;
    StatusItemDao statusItens;
    
    @Override
    protected ItemPregao setDados(ResultSet resultado) {
        try{
            ItemPregao obj = new ItemPregao();
            obj.setId(resultado.getInt("id"));
            obj.setQuantidade(resultado.getDouble("quantidade"));
            obj.setValorReferencia(resultado.getDouble("valorReferencia"));
            obj.setPregao(pregoes.Abrir(resultado.getInt("pregao")));
            obj.setProduto(produtos.Abrir(resultado.getInt("produtos")));
            obj.setForncedor(fornecedores.Abrir(resultado.getInt("fornecedores")));
            obj.setStatusItem(statusItens.Abrir(resultado.getInt("statusItens")));
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
