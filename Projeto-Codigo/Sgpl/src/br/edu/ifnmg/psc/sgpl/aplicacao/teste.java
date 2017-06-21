/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.aplicacao;

/**
 *
 * @author haw
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
        
        Fornecedor fornecedor1 = new Fornecedor(1, "Agroveterinária LTDa", "Casa do criador", "1234567890-22", "33 93732-3223", "cc@gmail.com");
        System.out.println(fornecedor1.toString());
        
        NotaEmpenho notaemprenho1 = new NotaEmpenho(1, "10/10/2010", 123.12, "Aberto", fornecedor1, pregao1, usuario1);
        System.out.println(notaemprenho1.toString());
        
        Produto produto = new Produto(1, "Computador", "12312321");
        
    }
}
