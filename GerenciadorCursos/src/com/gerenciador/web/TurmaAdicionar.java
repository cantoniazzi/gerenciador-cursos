package com.gerenciador.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gerenciador.dao.TurmaDAO;
import com.gerenciador.dao.CursoDAO;
import com.gerenciador.dao.InstrutorDAO;
import com.gerenciador.model.Curso;
import com.gerenciador.model.Instrutor;
import com.gerenciador.model.Turma;

public class TurmaAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/turmaadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim(); 
		
		if (request.getMethod().equals("GET")) {
			
			TurmaDAO turmaDAO = new TurmaDAO();
			Turma turma = new Turma();
			
			if (id != ""){
				try {
					turma = turmaDAO.load(Integer.parseInt(id));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			request.setAttribute("turma", turma);
			request.setAttribute("cursos", new CursoDAO().list());
			request.setAttribute("instrutores", new InstrutorDAO().list());
			
		} else {
			String obs = "";
			
			int instrutorId = request.getParameter("instrutorId").trim() != "" ? Integer.parseInt(request.getParameter("instrutorId").trim()) : 0;
			int cursoId = request.getParameter("cursoId").trim() !=  "" ? Integer.parseInt(request.getParameter("cursoId").trim()) : 0;
			String dataInicio = request.getParameter("dataInicio").trim() !=  "" ? request.getParameter("dataInicio").trim() : "";
			String dataFim = request.getParameter("dataFim").trim() !=  "" ? request.getParameter("dataFim").trim() : "";
			int cargaHoraria = request.getParameter("cargaHoraria").trim() != "" ? Integer.parseInt(request.getParameter("cargaHoraria").trim()) : 0;
			
			Turma turma = new Turma();
			InstrutorDAO instrutorDAO = new InstrutorDAO();
			CursoDAO cursoDAO = new CursoDAO();
			
	        Instrutor instrutor = new Instrutor();
	        Curso curso = new Curso();
	        
	        try {
				instrutor = instrutorDAO.load(instrutorId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        try {
	        	curso = cursoDAO.load(cursoId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
			turma.setInstrutor(instrutor);
			turma.setCurso(curso);
			
			turma.setDataInicio(dataInicio);
			turma.setDataFim(dataFim);
			turma.setCargaHoraria(cargaHoraria);
			
			if (turma.getCurso() == null) obs = obs + "Informe o curso <br>";
			if (turma.getInstrutor() == null) obs = obs + "Informe o instrutor<br>";		
			if (turma.getDataInicio() == "") obs = obs + "Informe a data de início<br>";		
			if (turma.getDataFim() == "") obs = obs + "Informa a data de fim<br>";		
			if (turma.getCargaHoraria() == 0) obs = obs + "Informa a carga horária<br>";		
			
			if (obs.equals("")) {
				
				TurmaDAO turmaDAO = new TurmaDAO();
				
				//check is edit/add curso
				if (!id.equals("0")){
					turma.setId(Integer.parseInt(id));
					turmaDAO.edit(turma);
				} else {
					turmaDAO.add(turma);
				}
				
				request.setAttribute("turmas", turmaDAO.list());
				
				page = "/WEB-INF/turmaslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("turma", turma);
				request.setAttribute("cursos", new CursoDAO().list());
				request.setAttribute("instrutores", new InstrutorDAO().list());
			}
			
		
		}
		
		return page;
	}

}
