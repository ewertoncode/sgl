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

public class Usuario implements Entidade{     
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Setor setor;
    private Endereco endereco;
    
    @Override
    public int getId(){
        return this.id;
    }
    
    @Override
    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    //Regra de Negócio UC2.1/RN1
    public void setNome(String nome) throws ViolacaoRegraDeNegocioException{
        if(nome == null || nome.length() < 8)
            throw new ViolacaoRegraDeNegocioException("O nome não pode ter menos do que 8 caracteres!");
        this.nome = nome;
    }
        
    public String getEmail() {
        
        return email;
    }
    
    //Regra de Negocio UC2.1/RN2
    public void setEmail(String email) throws ViolacaoRegraDeNegocioException{
        if(email == null || (!email.contains("@")) || (!email.contains(".com")))            
            throw new ViolacaoRegraDeNegocioException("O email deve conter formato válido(Ex:xxxxxx@xxxxx.com)!");
        this.email = email;
    }      

    public String getSenha() {
        return senha;
    }
    
    //Regra de Negócio UC2.1/RN3
    public void setSenha(String senha) throws ViolacaoRegraDeNegocioException{
        if(nome == null || nome.length() < 8)
            throw new ViolacaoRegraDeNegocioException("A senha não pode ter menos do que 8 caracteres!");
        this.senha = senha;
    }
    
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }        
    
    
    //Construtor1
    public Usuario() {
    }
        
    //Construtor2
    //Perguntar - this.setId(id);
    public Usuario(int id, String nome, String email, String senha, Setor setor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
    }
    
    //Construtor3
    public Usuario(int id, String nome, String email, String senha, Setor setor, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario: " + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", " + setor + ", " + endereco;
    }
    
    
}
