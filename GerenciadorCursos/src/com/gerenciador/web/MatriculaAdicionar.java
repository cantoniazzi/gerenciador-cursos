package com.gerenciador.web;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.AlunoDAO;
import com.gerenciador.dao.MatriculaDAO;
import com.gerenciador.dao.TurmaDAO;
import com.gerenciador.model.Aluno;
import com.gerenciador.model.Matricula;
import com.gerenciador.model.Turma;

public class MatriculaAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/matriculaadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim(); 
		
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		Matricula matricula = new Matricula();
		
		if (request.getMethod().equals("GET")) {
			
			if (id != ""){
				try {
					matricula = matriculaDAO.load(Integer.parseInt(id));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			request.setAttribute("matricula", matricula);
			request.setAttribute("turmas", new TurmaDAO().list());
			request.setAttribute("alunos", new AlunoDAO().list());
			
		} else {
			String obs = "";
			
			int turmaId = request.getParameter("turmaId").trim() != "" ? Integer.parseInt(request.getParameter("turmaId").trim()) : 0;
			int alunoId = request.getParameter("alunoId").trim() !=  "" ? Integer.parseInt(request.getParameter("alunoId").trim()) : 0;
			String dataMatricula = request.getParameter("dataMatricula").trim() !=  "" ? request.getParameter("dataMatricula").trim() : "";
			
	        Turma turma = new Turma();
	        Aluno aluno = new Aluno();
	        
	        try {
				turma = new TurmaDAO().load(turmaId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        try {
				aluno = new AlunoDAO().load(alunoId);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			matricula.setTurma(turma);
			matricula.setAluno(aluno);
			matricula.setDataMatricula(dataMatricula);
			
			if (matricula.getTurma() == null) obs = obs + "Informe a turma <br>";
			if (matricula.getAluno() == null) obs = obs + "Informe o aluno<br>";		
			if (matricula.getDataMatricula() == "") obs = obs + "Informa a data de matrícula<br>";		
			
			if (obs.equals("")) {
				
				//check is edit/add curso
				if (!id.equals("0")){
					matricula.setId(Integer.parseInt(id));
					matriculaDAO.edit(matricula);
				} else {
					matriculaDAO.add(matricula);
				}
				
				request.setAttribute("matriculas", matriculaDAO.list());
				
				page = "/WEB-INF/turmaslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("matricula", matricula);
				request.setAttribute("turmas", new TurmaDAO().list());
				request.setAttribute("alunos", new AlunoDAO().list());
			}
		
		}
		
		return page;
	}

}
