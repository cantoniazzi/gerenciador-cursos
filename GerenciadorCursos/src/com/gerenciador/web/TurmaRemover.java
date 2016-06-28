package com.gerenciador.web;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.TurmaDAO;
import com.gerenciador.model.Turma;

public class TurmaRemover implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/turmaremover.jsp";
		String id = request.getParameter("id").trim();
		
		Turma turma = new Turma();
		TurmaDAO turmaDAO = new TurmaDAO();

		if (id != ""){
			try {
				turma = turmaDAO.load(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("turma", turma);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				turmaDAO.delete(turma);
				request.setAttribute("turmas", turmaDAO.list());
				page = "/WEB-INF/turmaslistar.jsp";
			}
		}
				
		return page;
	}

}
