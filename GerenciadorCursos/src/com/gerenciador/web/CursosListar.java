package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gerenciador.dao.CursoDAO;

public class CursosListar implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String  page = "/WEB-INF/cursoslistar.jsp";
		
		if (request.getMethod().equals("GET")) {
			
			request.setAttribute("cursos", new CursoDAO().list());
			
		}

		return page;
	}

}
