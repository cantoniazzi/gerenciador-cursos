package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoExibir implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "WEB-INF/alunoexibir.jsp";
		
		if (request.getMethod().equals("GET")){
			
		}
		
		return page;
	}

}
