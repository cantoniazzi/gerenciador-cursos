package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.AlunoDAO;
import com.gerenciador.dao.MatriculaDAO;
import com.gerenciador.dao.TurmaDAO;
import com.gerenciador.model.Matricula;

public class MatriculaAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/matriculaadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim(); 
		
		if (request.getMethod().equals("GET")) {
			
			MatriculaDAO matriculaDAO = new MatriculaDAO();
			Matricula matricula = new Matricula();
			
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
			
		}
		
		return page;
	}

}
