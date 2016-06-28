package com.gerenciador.web;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.AlunoDAO;
import com.gerenciador.model.Aluno;

public class AlunoAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = "/WEB-INF/alunoadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
		
		if (request.getMethod().equals("GET")) {
			
			if (id != ""){
				
				AlunoDAO alunoDAO = new AlunoDAO();
				Aluno aluno = new Aluno();
				
				try {
					aluno = alunoDAO.load(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException | SQLException | ParseException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("aluno", aluno);
			}
			
			
		} else {
			String obs = "";
			
			String nome = request.getParameter("nome").trim() != "" ? request.getParameter("nome").trim() : "";
			String cpf = request.getParameter("cpf").trim() !=  "" ? request.getParameter("cpf").trim() : "";
			String email = request.getParameter("email").trim() !=  "" ? request.getParameter("email").trim() : "";
			String fone = request.getParameter("fone").trim() !=  "" ? request.getParameter("fone").trim() : "";
			String dataNascimento = request.getParameter("dataNascimento").trim() !=  "" ? request.getParameter("dataNascimento").trim() : "";
			
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setCpf(cpf);
			aluno.setEmail(email);
			aluno.setFone(fone);
			aluno.setDataNascimento(dataNascimento);
			
			if (aluno.getNome() == "") obs = obs + "Informe o nome <br>";
			if (aluno.getCpf() == "") obs = obs + "Informe o cpf<br>";		
			if (aluno.getEmail() == "") obs = obs + "Informe o email<br>";		
			if (aluno.getFone() == "") obs = obs + "Informe o fone<br>";		
			if (aluno.getDataNascimento() == "") obs = obs + "Informe a data de nascimento";
			
			if (obs.equals("")) {
				AlunoDAO alunoDAO = new AlunoDAO();
				
				//check is edit/add aluno
				if (id != ""){
					aluno.setId(Integer.parseInt(id));
					alunoDAO.edit(aluno);
				} else {
					alunoDAO.add(aluno);
				}
				
				request.setAttribute("alunos", alunoDAO.list());
				
				page = "/WEB-INF/alunoslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("aluno", aluno);
			}		
		}
		
		return page;
	}

}
