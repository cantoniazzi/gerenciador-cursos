package com.gerenciador.model;

public class Instrutor {
	private int id;
	private String nome;
	private String email;
	private double valorHora;
	private String certificados;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public String getCertificados() {
		return certificados;
	}
	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}
}
