package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.UsuarioDAO;

public class UsuariosListar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String  page = "/WEB-INF/usuarioslistar.jsp";
		
		if (request.getMethod().equals("GET")) {
			
			request.setAttribute("usuarios", new UsuarioDAO().list());
		}

		return page;
	}

}
