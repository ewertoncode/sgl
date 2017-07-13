package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import br.edu.ifnmg.psc.sgpl.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Setor;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.EnderecoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.FornecedorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PedidoDao;
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
    /*
    public static void main(String[] args){
                  
        try{            
            
            UsuarioRepositorio dao = new UsuarioDao();            
            SetorRepositorio dao2 = new SetorDao();
            FornecedorRepositorio dao3 = new FornecedorDao();
            EnderecoRepositorio dao4 = new EnderecoDao();
            PedidoRepositorio dao5 = new PedidoDao();
            
            Setor setor = new Setor(0, "Setor1");            
            Endereco endereco = new Endereco(0,"Rua do Binário", 10, "Casa Verde", "Sete Setembro", "Januária", "39480-000", "MG", "Brasil");
            Usuario usuario = new Usuario(5, "Joao Paulo", "jp@gmail.com", "123", setor, endereco);                        
            Fornecedor fornecedor = new Fornecedor(0, "Luis LTDA", "Distribuidora do Luis", "1921281281", "luisLTDA@gmail.com", "123123");           
            Pedido pedido = new Pedido(0, "2017-07-04", usuario);
            
            
            //System.out.println(dao2.Salvar(setor));
            //System.out.println(dao.Abrir(7));
            //System.out.println(dao3.Salvar(fornecedor));
            //System.out.println(dao4.Salvar(endereco));
            System.out.println(dao5.Salvar(pedido));
            
        }catch(ClassNotFoundException | SQLException e){            
            System.out.println("Algo deu Errado :/");
            System.out.println(e.getMessage());
        }         
    }    
*/
}
       