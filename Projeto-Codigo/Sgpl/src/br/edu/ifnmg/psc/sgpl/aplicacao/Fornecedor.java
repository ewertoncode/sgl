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
public class Fornecedor implements Entidade{
    
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String telefone;
    private String email;
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override    
    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    //Construtor1
    public Fornecedor() {
    }

    public Fornecedor(int id, String razaoSocial, String nomeFantasia, String cnpj, String telefone, String email) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + "id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", telefone=" + telefone + ", email=" + email + ' ';
    }    
    
}
