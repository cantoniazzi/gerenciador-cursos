package com.gerenciador.model;

import java.util.ArrayList;

public class Curso {
	private int id;
	private String nome;
	private ArrayList<String> requisitos;
	private int carga_horaria;
	private double preco;
	
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
	public ArrayList<String> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisito) {
		this.requisitos.add(requisito);
	}
	public int getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
