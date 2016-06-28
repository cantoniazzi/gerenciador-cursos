package com.gerenciador.model;

public class Turma {
	private int id;
	private Instrutor instrutor;
	private Curso curso;
	private String dataInicio;
	private String dataFim;
	private int cargaHoraria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Instrutor getInstrutor() {
		return this.instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	public Curso getCurso() {
		return this.curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
}
