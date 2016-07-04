package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/login.jsp";
		
		HttpSession session = request.getSession();
		session.setAttribute("UsuarioId", null);
		
		return page;
	}
	
}
