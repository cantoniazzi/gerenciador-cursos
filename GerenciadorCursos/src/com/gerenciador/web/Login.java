package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.model.Usuario;
import com.gerenciador.dao.UsuarioDAO;

public class Login implements Acao {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		
		String page = "/WEB-INF/login.jsp";
		
		if (request.getMethod().equals("GET")) {
		
		} 
		else if (request.getMethod().equals("POST")){
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			if ((email == "") || (senha == "")) {
				
				request.setAttribute("obs", "Email ou senha inválido(s)!");
			
			} else {

				Usuario usuario = new UsuarioDAO().Login(email, senha);
				if (!usuario.getLogado()) {
					request.setAttribute("obs", "Email ou senha inválido(s)!");
					return page;
				} else {
					page = "/WEB-INF/inicio.jsp";
				}
				
			}
			
		}
		
		return page;
	}

}