package com.gerenciador.model;

import java.util.ArrayList;

public class Curso {
	private int id;
	private String nome;
	private String requisito;
	private int cargaHoraria;
	private double preco;
	
	public int getId() {
		return this.id;
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
	public String getRequisito() {
		return this.requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
