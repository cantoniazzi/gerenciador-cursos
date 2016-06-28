package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.InstrutorDAO;
import com.gerenciador.model.Instrutor;

public class InstrutorAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/instrutoradicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim(); 
		
		InstrutorDAO instrutorDAO = new InstrutorDAO();
		Instrutor instrutor = new Instrutor();
		
		if (request.getMethod().equals("GET")) {
			
			if (id != ""){
				try {
					instrutor = instrutorDAO.load(Integer.parseInt(id));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("instrutor", instrutor);
			
			}
			
		} else {
			String obs = "";
			
			String nome = request.getParameter("nome").trim() != "" ? request.getParameter("nome").trim() : "";
			String email = request.getParameter("email").trim() !=  "" ? request.getParameter("email").trim() : "";
			double valorHora = request.getParameter("valorHora") != "" ? Double.parseDouble(request.getParameter("valorHora")) : 0.0;
			String certificados = request.getParameter("certificados").trim() !=  "" ? request.getParameter("certificados").trim() : "";
			
			instrutor.setNome(nome);
			instrutor.setEmail(email);
			instrutor.setValorHora(valorHora);
			instrutor.setCertificados(certificados);
			
			if (instrutor.getNome() == "") obs = obs + "Informe o nome <br>";
			if (instrutor.getEmail() == "") obs = obs + "Informe o email<br>";		
			if (instrutor.getValorHora() == 0) obs = obs + "Informe o valor hora<br>";		
			if (instrutor.getCertificados() == "") obs = obs + "Informe os certificados";		
			
			if (obs.equals("")) {
				
				//check is edit/add curso
				if (id != ""){
					instrutor.setId(Integer.parseInt(id));
					instrutorDAO.edit(instrutor);
				} else {
					instrutorDAO.add(instrutor);
				}
				
				request.setAttribute("instrutores", instrutorDAO.list());
				
				page = "/WEB-INF/instrutoreslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("instrutor", instrutor);
			}
			
		
		}
		
		return page;
	}

}
