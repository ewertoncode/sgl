package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Endereco;
import br.edu.ifnmg.psc.sgpl.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.HistoricoRenegociacao;
import br.edu.ifnmg.psc.sgpl.aplicacao.HistoricoRenegociacaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenho;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenhoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotificacaoFornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.NotificacaoFornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.PregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Setor;
import br.edu.ifnmg.psc.sgpl.aplicacao.SetorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.StatusItem;
import br.edu.ifnmg.psc.sgpl.aplicacao.StatusItemRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.EnderecoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.FornecedorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.HistoricoRenegociacaoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ItemPedidoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ItemPregaoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.NotaEmpenhoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.NotificacaoFornecedorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PedidoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PregaoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.ProdutoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.SetorDao;
import br.edu.ifnmg.psc.sgpl.persistencia.StatusItemDao;
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
<<<<<<< HEAD
    public static void main(String[] args) {

        try {

            UsuarioRepositorio dao = new UsuarioDao();
=======
    /*
    public static void main(String[] args){
                  
        try{            
            
            UsuarioRepositorio dao = new UsuarioDao();            
>>>>>>> 5846859a9fa065a83e71aaee610a46769f7d92da
            SetorRepositorio dao2 = new SetorDao();
            FornecedorRepositorio dao3 = new FornecedorDao();
            EnderecoRepositorio dao4 = new EnderecoDao();
            PedidoRepositorio dao5 = new PedidoDao();
            PregaoRepositorio dao6 = new PregaoDao();
            StatusItemRepositorio dao7 = new StatusItemDao();
            NotaEmpenhoRepositorio dao8 = new NotaEmpenhoDao();
            //ProdutoRepositorio dao9 = new ProdutoDao();
            ItemPedidoRepositorio dao10 = new ItemPedidoDao();
            HistoricoRenegociacaoRepositorio dao11 = new HistoricoRenegociacaoDao();
            ItemPregaoRepositorio dao12 = new ItemPregaoDao();
            NotificacaoFornecedorRepositorio dao13 = new NotificacaoFornecedorDao();
            
            
            Setor setor = new Setor(0, "Setor1");
            Endereco endereco = new Endereco(0, "Rua do Binário", "10", "Casa Verde", "Sete Setembro", "Januária", "39480-000", "MG", "Brasil");
            Usuario usuario = new Usuario(5, "Joao Paulo", "jp@gmail.com", "123", setor, endereco);
            Fornecedor fornecedor1 = new Fornecedor(30, "Luis1 LTDA", "Distribuidora do Luis", "1921281281", "luisLTDA@gmail.com", "123123");
            Fornecedor fornecedor2 = new Fornecedor(31, "Luis2 LTDA", "Distribuidora do Luis", "1921281281", "luisLTDA@gmail.com", "123123");
            Fornecedor fornecedor3 = new Fornecedor(32, "Luis3 LTDA", "Distribuidora do Luis", "1921281281", "luisLTDA@gmail.com", "123123");
            Pedido pedido = new Pedido(1, "2017-07-04", usuario);
            Pregao pregao = new Pregao(0, "2017-07-04", "2017-07-06", pedido, usuario);
            StatusItem statusItem = new StatusItem(2, "Ativos");
            NotaEmpenho notaEmpenho = new NotaEmpenho(2, "2017-07-04", 10.35, "Desativado", fornecedor1, pregao, usuario);
            Produto produto = new Produto(0, "Notebook", "919182");
            ItemPedido itemPedido = new ItemPedido(2, 20, fornecedor1, 5.8, fornecedor2, 4.6, fornecedor3, 6, pedido, produto);
            HistoricoRenegociacao historicoRenegociacao = new HistoricoRenegociacao(2, "Pagara corretamente...", "2017-07-10", pregao, fornecedor3, usuario);
            ItemPregao itemPregao = new ItemPregao(2, 10, 30, pregao, produto, fornecedor3, statusItem);
            NotificacaoFornecedor notificacaoFornecedor = new NotificacaoFornecedor(2, "Em curso....", "2017-07-10", 1, fornecedor3, pregao);
            
            
            
            //System.out.println(dao2.Salvar(setor));
            //System.out.println(dao.Abrir(7));
            //System.out.println(dao3.Salvar(fornecedor));
            //System.out.println(dao4.Salvar(endereco));
            //System.out.println(dao5.Salvar(pedido));
            //System.out.println(dao6.Salvar(pregao));
            //System.out.println(dao7.Apagar(statusItem));
            //System.out.println(dao8.Apagar(notaEmpenho));
            //System.out.println(dao10.Apagar(itemPedido));
            //System.out.println(dao11.Apagar(historicoRenegociacao));
            //System.out.println(dao12.Apagar(itemPregao));
            System.out.println(dao13.Apagar(notificacaoFornecedor));
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Algo deu Errado :/");
            System.out.println(e.getMessage());
<<<<<<< HEAD
        }
    }
=======
        }         
    } 
*/
>>>>>>> 5846859a9fa065a83e71aaee610a46769f7d92da

}