package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.MatriculaDAO;
import com.gerenciador.model.Matricula;

public class MatriculaRemover implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/matricularemover.jsp";
		String id = request.getParameter("id").trim();
		
		Matricula matricula = new Matricula();
		MatriculaDAO matriculaDAO = new MatriculaDAO();

		if (id != ""){
			try {
				matricula = matriculaDAO.load(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("matricula", matricula);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				matriculaDAO.delete(matricula);
				request.setAttribute("matriculas", matriculaDAO.list());
				page = "/WEB-INF/matriculaslistar.jsp";
			}
		}
				
		return page;
	}

}
