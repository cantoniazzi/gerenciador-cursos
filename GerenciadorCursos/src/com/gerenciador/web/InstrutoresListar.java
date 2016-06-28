package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.InstrutorDAO;

public class InstrutoresListar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String  page = "/WEB-INF/instrutoreslistar.jsp";
		
		if (request.getMethod().equals("GET")) {
			
			InstrutorDAO instrutorDAO = new InstrutorDAO();
			
			request.setAttribute("instrutores", instrutorDAO.list());
			
		}

		return page;
	}

}
