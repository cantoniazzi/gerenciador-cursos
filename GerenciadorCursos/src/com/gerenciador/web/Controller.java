package com.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Controller")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		acao = "com.gerenciador.web." + acao;
		
		try {
			
			Class<?> tipo = Class.forName(acao);
			Acao instancia = (Acao) tipo.newInstance();
			String pagina = instancia.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}

}