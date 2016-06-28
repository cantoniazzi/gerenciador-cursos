package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.TurmaDAO;

public class TurmasListar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String  page = "/WEB-INF/turmaslistar.jsp";
		
		if (request.getMethod().equals("GET")) {
			
			request.setAttribute("turmas", new TurmaDAO().list());
			
		}

		return page;
	}

}
