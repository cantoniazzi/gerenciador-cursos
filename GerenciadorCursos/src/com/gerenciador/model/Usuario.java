package com.gerenciador.model;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String tipo;
    private Boolean logado = false;
   
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public Boolean getLogado(){
        return this.logado;
    }
    public void setLogado(Boolean logado){
        this.logado = logado;
    }
}
