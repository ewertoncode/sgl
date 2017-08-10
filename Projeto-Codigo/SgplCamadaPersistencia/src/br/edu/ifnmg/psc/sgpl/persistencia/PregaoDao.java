/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.PregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregao;

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
    
    protected String getMaxId() {
        return "select max(id) as maxId from pregao";
    }
    
    protected String getConsutaBuscaItens() {
        return "select * from pregao_itens where pregao_id =?";
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
    
    public Pregao getLast(){
        
        try {        
            PreparedStatement sql = conexao.prepareStatement(this.getMaxId());
            
            ResultSet resultado = sql.executeQuery();  
            while(resultado.next()) {
                return this.Abrir(resultado.getInt("maxId"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
        
        return null;
    }
    
    @Override
    public Pregao Abrir(int id){

        try{
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaAbrir());

            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();            
            if(resultado.next()) {
                Pregao pregao = new Pregao();
                pregao.setId(resultado.getInt("id"));
                pregao.setData(resultado.getDate("data"));
                pregao.setDiasEntrega(resultado.getInt("diasEntrega"));
                if(resultado.getInt("pedido") > 0)
                    pregao.setPedido(pedidos.Abrir(resultado.getInt("pedido")));
                    else 
                        pregao.setPedido(null);

                    if(resultado.getInt("usuario") > 0) 
                        pregao.setUsuario(usuarios.Abrir(resultado.getInt("usuario")));
                    else
                        pregao.setUsuario(null);
                
                List<ItemPregao> listaItens = new ArrayList<>();
                PreparedStatement sqlItens = conexao.prepareStatement(this.getConsutaBuscaItens());
            
                sqlItens.setInt(1, pregao.getId());

                ResultSet resultadoItens = sqlItens.executeQuery();
                
                while(resultadoItens.next()) {
                    
                    ProdutoRepositorio produtoDao = null;
                    try {
                        produtoDao = new ProdutoDao();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ItemPregao item = new ItemPregao();
                    item.setId(resultadoItens.getInt("id"));
                    Produto produto = produtoDao.Abrir(resultadoItens.getInt("produto_id"));
                    item.setProduto(produto);
                    item.setQuantidade(resultadoItens.getInt("qtd"));
                    item.setValorReferencia(resultadoItens.getDouble("valor_referencia"));
                    
                    listaItens.add(item);
                }
                
                pregao.setItens(listaItens);
                
                return pregao;
                
            }
            else
                return null;
            
        }catch(SQLException e){
            Logger.getLogger(DaoGenerico.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return null;
    }
    
    
}
