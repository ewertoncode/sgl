package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import br.edu.ifnmg.psc.sgpl.aplicacao.Setor;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.DaoGenerico;
import br.edu.ifnmg.psc.sgpl.persistencia.SetorDao;
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
    public static void main(String[] args){
                  
        try{            
            
            UsuarioRepositorio dao = new UsuarioDao();            
            SetorRepositorio dao2 = new SetorDao();
            
            Setor setor = new Setor(0, "Setor1");            
            Endereco endereco = new Endereco(1,"Rua Jatobá", 10, "Casa Verde", "Sete Setembro", "Januária", "39480-000", "MG", "Brasil");
            Usuario usuario = new Usuario(0, "Joao Paulo", "jp@gmail.com", "123", setor, endereco);                        
            
            System.out.println(dao2.Salvar(setor));
            System.out.println(dao.Abrir(7));
            
        }catch(Exception e){            
            System.out.println("Entrou");
            System.out.println(e.getMessage());
        }
         
    }
    
}
       