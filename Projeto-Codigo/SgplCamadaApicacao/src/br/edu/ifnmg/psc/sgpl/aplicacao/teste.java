/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

/**
 *
 * @author Emerson Pereira
 */

public class teste {
    public static void main(String[] args) throws ViolacaoRegraDeNegocioException {
                
        Setor setor1 = new Setor(1, "RH");
        
        Usuario usuario1 = new Usuario(1, "João", "joão@gmail.com", "123", setor1);
        System.out.println(usuario1.toString());            
        
        Endereco endereco = new Endereco(1,"Rua Jatobá", 10, "Casa Verde", "Sete Setembro", "Januária", "39480-000", "MG", "Brasil");
        usuario1.setEndereco(endereco);
        System.out.println(usuario1.toString());
        
        Pedido pedido1 = new Pedido(1, "10/10/2010", usuario1);
        System.out.println(pedido1.toString());
        
        Pregao pregao1 = new Pregao(1, "10/10/2010", "10/10/2011", pedido1, usuario1);
        System.out.println(pregao1.toString());
        
        Fornecedor fornecedor1 = new Fornecedor(1, "Agroveterinária LTDa1", "Casa do criador1", "1234567890-22", "33 93732-3223", "cc@gmail.com");
        Fornecedor fornecedor2 = new Fornecedor(2, "Agroveterinária LTDa2", "Casa do criador2", "1234567890-22", "33 93732-3223", "cc@gmail.com");
        Fornecedor fornecedor3 = new Fornecedor(3, "Agroveterinária LTDa3", "Casa do criador3", "1234567890-22", "33 93732-3223", "cc@gmail.com");
        System.out.println(fornecedor1.toString());
        
        
        NotaEmpenho notaemprenho1 = new NotaEmpenho(1, "10/10/2010", 123.12, "Aberto", fornecedor1, pregao1, usuario1);
        System.out.println(notaemprenho1.toString());
        
        Produto produto1 = new Produto(1, "Computador", "12312321");
        System.out.println(produto1.toString());
        Produto produto2 = new Produto(1, "Cadeira", "333333");
        Produto produto3 = new Produto(1, "Mesa", "222222");
                
        ItemPedido itemPedido1 = new ItemPedido(1, 4, fornecedor1, 12.00, fornecedor2, 14.00 , fornecedor3, 12.50, pedido1, produto3);
        ItemPedido itemPedido2 = new ItemPedido(2, 15, fornecedor1, 150.00, fornecedor2, 200.00, fornecedor3, 125.00, pedido1, produto2);
        ItemPedido itemPedido3 = new ItemPedido(3, 9, fornecedor1, 12.00, fornecedor2, 14.00 , fornecedor3, 12.50, pedido1, produto1);
        System.out.println(itemPedido1.toString());
        
        StatusItem statusItem1 = new StatusItem(1, "Ativo");
        
        ItemPregao itemPregao = new ItemPregao(1, 24, 240, pregao1, produto3, fornecedor3, statusItem1);
        System.out.println(statusItem1.toString());
        
        NotificacaoFornecedor notificacaoFornecedor1 = new NotificacaoFornecedor(1, "Entrega Pendente", "13102017", 1, fornecedor3, pregao1);
        System.out.println(notificacaoFornecedor1.toString());
        
        HistoricoRenegociacao historicoRenegociacao1 = new HistoricoRenegociacao(1, "Ocorreu tudo bem", "12122018", pregao1, fornecedor3, usuario1);
        System.out.println(historicoRenegociacao1.toString());
    }
}
