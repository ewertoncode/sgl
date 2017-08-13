/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgpl.persistencia;

import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenho;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenhoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import java.sql.Date;
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
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into notas_empenho(numero_nota, item, valor, pago, data_pagamento) values (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update notas_empenho set numero_nota = ?, item = ?, valor = ?, pago = ?, data_pagamento = ? where id = ?";
    } 

    @Override
    protected String getConsultaDelete() {
        return "delete from notas_empenho where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select * from notas_empenho where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select * from notas_empenho";
    }

    @Override
    protected void setBuscaFiltros(NotaEmpenho filtro) {

        if(filtro.isPago()) {
            
            this.adicionarFiltro("pago", 1);
        }

    }

    @Override
    protected void setParametros(PreparedStatement sql, NotaEmpenho obj) {
        try{            
            sql.setInt(1, obj.getNumeroNota());            
            sql.setInt(2, obj.getItemPregao().getId());            
            sql.setDouble(3, obj.getValor());
            sql.setBoolean(4, obj.isPago());

            if(obj.getDataPagamento() != null) {
                sql.setDate(5, (Date) obj.getDataPagamento());
            } else {
                sql.setDate(5, null);
            }
            
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
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
            obj.setPago(resultado.getBoolean("pago"));  
            obj.setNumeroNota(resultado.getInt("numero_nota"));
            
            try {
                ItemPregaoDao itemPregaoDao = new ItemPregaoDao();
                obj.setItemPregao(itemPregaoDao.Abrir(resultado.getInt("item")));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NotaEmpenhoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(resultado.getDate("data_pagamento") != null) {
                obj.setDataPagamento(resultado.getDate("data_pagamento"));
            }
          
            return obj;
            
        }catch(SQLException e){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
