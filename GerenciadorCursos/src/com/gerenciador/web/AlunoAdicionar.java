package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/alunosadicionar.jsp";
		
		if (request.getMethod().equals("POST")) {
			
		}
		
		return page;
	}

}
