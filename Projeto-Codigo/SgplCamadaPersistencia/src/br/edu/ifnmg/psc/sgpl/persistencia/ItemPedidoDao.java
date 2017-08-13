/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedidoRepositorio;
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
public class ItemPedidoDao extends DaoGenerico<ItemPedido> implements ItemPedidoRepositorio{
    
    public ItemPedidoDao() throws ClassNotFoundException, SQLException{
        super();
        fornecedor1 = new FornecedorDao();
        fornecedor2 = new FornecedorDao();
        fornecedor3 = new FornecedorDao();
        pedidos = new PedidoDao();
        produtos = new ProdutoDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into item_pedido(quantidade, fornecedor1, valorFornecedor1, fornecedor2, valorFornecedor2, fornecedor3, valorFornecedor3, pedido, produto) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update item_pedido set quantidade = ?, fornecedor1 = ?, valorFornecedor1 = ?, fornecedor2 = ?, valorFornecedor2 = ?, fornecedor3 = ?, valorFornecedor3 = ?, pedido = ?, produto = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from item_pedido where id = ?";
    }   

    @Override
    protected String getConsultaAbrir() {
        return "select * from item_pedido where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from item_pedido";
    }
    
    

    @Override
    protected void setBuscaFiltros(ItemPedido filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());        
    }

    @Override
    protected void setParametros(PreparedStatement sql, ItemPedido obj) {
        try{            
            sql.setDouble(1, obj.getQuantidade());                                
            sql.setInt(2, obj.getFornecedor1().getId());      
            sql.setDouble(3, obj.getValorFornecedor1());                
            sql.setInt(4, obj.getFornecedor2().getId());    
            sql.setDouble(5, obj.getValorFornecedor2());                        
            sql.setInt(6, obj.getFornecedor3().getId());            
            sql.setDouble(7, obj.getValorFornecedor3());            
            sql.setInt(8, obj.getPedido().getId());
            sql.setInt(9, obj.getProduto().getId());
            
            if(obj.getId() > 0)
                sql.setInt(10, obj.getId());
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    FornecedorDao fornecedor1;
    FornecedorDao fornecedor2;
    FornecedorDao fornecedor3;
    PedidoDao pedidos;
    ProdutoDao produtos;
    
    @Override
    protected ItemPedido setDados(ResultSet resultado) {
        try{
            ItemPedido obj = new ItemPedido();
            obj.setId(resultado.getInt("id"));
            obj.setQuantidade(resultado.getDouble("quantidade"));
            obj.setFornecedor1(fornecedor1.Abrir(resultado.getInt("fornecedor1")));
            obj.setValorFornecedor1(resultado.getDouble("valorFornecedor1"));
            obj.setFornecedor2(fornecedor2.Abrir(resultado.getInt("fornecedor2")));
            obj.setValorFornecedor2(resultado.getDouble("valorFornecedor2"));
            obj.setFornecedor3(fornecedor3.Abrir(resultado.getInt("fornecedor3")));
            obj.setValorFornecedor3(resultado.getDouble("valorFornecedor3"));
            obj.setPedido(pedidos.Abrir(resultado.getInt("pedido")));
            obj.setProduto(produtos.Abrir(resultado.getInt("produto")));            
            
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
