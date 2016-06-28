package com.gerenciador.model;

public class Matricula {
	private int id;
	private Turma turma;
	private Aluno aluno;
	private String dataMatricula;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Turma getTurma() {
		return this.turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
}
