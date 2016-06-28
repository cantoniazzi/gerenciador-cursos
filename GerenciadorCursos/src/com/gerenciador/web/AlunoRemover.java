package com.gerenciador.web;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.AlunoDAO;
import com.gerenciador.model.Aluno;

public class AlunoRemover implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/alunoremover.jsp";
		String id = request.getParameter("id").trim();
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = new Aluno();

		if (id != ""){
			try {
				aluno = alunoDAO.load(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException | ParseException e) {
				e.printStackTrace();
			}
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("aluno", aluno);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				alunoDAO.delete(aluno);
				request.setAttribute("alunos", alunoDAO.list());
				page = "/WEB-INF/alunoslistar.jsp";
			}
		}
				
		return page;
	}

}
