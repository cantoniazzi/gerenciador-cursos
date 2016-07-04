package com.gerenciador.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private Boolean logado = false;
   
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public Boolean getLogado(){
        return this.logado;
    }
    public void setLogado(Boolean logado){
        this.logado = logado;
    }
}
