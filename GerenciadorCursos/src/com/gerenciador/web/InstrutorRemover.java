package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.InstrutorDAO;
import com.gerenciador.model.Instrutor;

public class InstrutorRemover implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/instrutorremover.jsp";
		String id = request.getParameter("id").trim();
		
		InstrutorDAO instrutorDAO = new InstrutorDAO();
		Instrutor instrutor = new Instrutor();

		if (id != ""){
			
			try {
				instrutor = instrutorDAO.load(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("instrutor", instrutor);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				instrutorDAO.delete(instrutor);
				request.setAttribute("instrutores", instrutorDAO.list());
				page = "/WEB-INF/instrutoreslistar.jsp";
			}
			
		}
		
		
		return page;
	}


}
