package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Acao {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		
		String page = "/WEB-INF/login.jsp";
		
		if (request.getMethod().equals("GET")) {
		
		} 
		else if (request.getMethod().equals("POST")){
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			if ((email == "") || (senha == ""))
				request.setAttribute("obs", "Email ou senha inválido(s)!");			
			
		}
		
		return page;
	}

}