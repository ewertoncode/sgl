/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import br.edu.ifnmg.psc.sgpl.aplicacao.Setor;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.DaoGenerico;
import br.edu.ifnmg.psc.sgpl.persistencia.UsuarioDao;
import java.sql.SQLException;

/**
 *
 * @author Emerson Pereira
 */
public class SgplCamadaApresentacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
                                
        //try{            
            
            UsuarioRepositorio dao = new UsuarioDao();            
            
            Setor setor = new Setor(1, "Setor1");            
            Endereco endereco = new Endereco(1,"Rua Jatobá", 10, "Casa Verde", "Sete Setembro", "Januária", "39480-000", "MG", "Brasil");
            Usuario usuario = new Usuario(0, "Joao Paulo", "jp@gmail.com", "123", setor, endereco);                        
            
            System.out.println(dao.Salvar(usuario));
            
            
        /*}catch(Exception e){
            System.out.println("Entrou");
            System.out.println(e.getMessage());
        }*/
        
    }
    
}

