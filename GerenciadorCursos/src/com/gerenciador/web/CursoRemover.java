package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.CursoDAO;
import com.gerenciador.model.Curso;

public class CursoRemover implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/cursoremover.jsp";
		String id = request.getParameter("id").trim();
		
		CursoDAO cursoDAO = new CursoDAO();
		Curso curso = new Curso();

		if (id != ""){
			
			try {
				curso = cursoDAO.load(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("curso", curso);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				cursoDAO.delete(curso);
				request.setAttribute("cursos", cursoDAO.list());
				page = "/WEB-INF/cursoslistar.jsp";
			}
			
		}
		
		
		return page;
	}

}
