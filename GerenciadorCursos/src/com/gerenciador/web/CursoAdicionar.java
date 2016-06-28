package com.gerenciador.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gerenciador.dao.CursoDAO;
import com.gerenciador.model.Curso;

public class CursoAdicionar implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/cursoadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
		
		if (request.getMethod().equals("GET")) {
			
			if (id != ""){
				
				CursoDAO cursoDAO = new CursoDAO();
				Curso curso = new Curso();
				try {
					curso = cursoDAO.load(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("curso", curso);
			
			}
			
			
		} else {
			String obs = "";
			
			String nome = request.getParameter("nome").trim() != "" ? request.getParameter("nome").trim() : "";
			String requisito = request.getParameter("requisito").trim() !=  "" ? request.getParameter("requisito").trim() : "";
			int cargaHoraria = request.getParameter("cargaHoraria").trim() != "" ? Integer.parseInt(request.getParameter("cargaHoraria")) : 0; 
			double preco = request.getParameter("preco") != "" ? Double.parseDouble(request.getParameter("preco")) : 0.0;
			
			Curso curso = new Curso();
			curso.setNome(nome);
			curso.setRequisito(requisito.trim());
			curso.setCargaHoraria(cargaHoraria);
			curso.setPreco(preco);
			
			if (curso.getNome() == "") obs = obs + "Informe o nome <br>";
			if (curso.getRequisito() == "") obs = obs + "Informe o requisito<br>";		
			if (curso.getCargaHoraria() == 0) obs = obs + "Informe a carga horária<br>";		
			if (curso.getPreco() == 0) obs = obs + "Informe o preço";		
			
			if (obs.equals("")) {
				CursoDAO cursoDAO = new CursoDAO();
				
				//check is edit/add curso
				if (id != ""){
					curso.setId(Integer.parseInt(id));
					cursoDAO.edit(curso);
				} else {
					cursoDAO.add(curso);
				}
				
				request.setAttribute("cursos", cursoDAO.list());
				
				page = "/WEB-INF/cursoslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("curso", curso);
			}		
		}
		
		return page;
	}

}
