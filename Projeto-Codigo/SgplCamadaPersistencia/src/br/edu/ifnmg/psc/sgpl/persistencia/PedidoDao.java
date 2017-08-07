/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson Pereira
 */
public class PedidoDao extends DaoGenerico<Pedido> implements PedidoRepositorio{
           
    public PedidoDao() throws ClassNotFoundException, SQLException {
        super();
        usuario = new UsuarioDao();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into pedido(data, usuario) values(?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pedido set data=?, usuario=? where id=?";
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
    
    protected String getConsutaBuscaItens() {
        return "select * from item_pedido where pedido =?";
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
    
    UsuarioDao usuario;
            
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
    
    
    @Override
    public Pedido Abrir(int id){

        try{
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaAbrir());

            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();            
            if(resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultado.getInt("id"));
                pedido.setData(resultado.getString("data"));
                
                List<ItemPedido> listaItens = new ArrayList<>();
                PreparedStatement sqlItens = conexao.prepareStatement(this.getConsutaBuscaItens());
            
                sqlItens.setInt(1, pedido.getId());

                ResultSet resultadoItens = sqlItens.executeQuery();
                
                while(resultadoItens.next()) {
                    
                    ProdutoRepositorio produtoDao = null;
                    try {
                        produtoDao = new ProdutoDao();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ItemPedido item = new ItemPedido();
                    item.setId(resultadoItens.getInt("id"));
                    Produto produto = produtoDao.Abrir(resultadoItens.getInt("produto"));
                    item.setQuantidade(resultadoItens.getInt("quantidade"));
                    item.setValorFornecedor1(resultadoItens.getDouble("valorFornecedor1"));
                    item.setValorFornecedor2(resultadoItens.getDouble("valorFornecedor2"));
                    item.setValorFornecedor3(resultadoItens.getDouble("valorFornecedor3"));
                    item.setProduto(produto);
                    listaItens.add(item);
                }
                
                pedido.setItens(listaItens);
                
                return pedido;
                
            }
            else
                return null;
            
        }catch(SQLException e){
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return null;
    }


}
