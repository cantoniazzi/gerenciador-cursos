package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.MatriculaDAO;

public class MatriculasListar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String  page = "/WEB-INF/matriculaslistar.jsp";
		
		if (request.getMethod().equals("GET")) {
			
			request.setAttribute("matriculas", new MatriculaDAO().list());
			
		}

		return page;
	}

}
