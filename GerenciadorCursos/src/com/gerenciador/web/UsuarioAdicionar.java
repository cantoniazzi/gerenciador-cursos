package com.gerenciador.web;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.UsuarioDAO;
import com.gerenciador.model.Usuario;

public class UsuarioAdicionar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/usuarioadicionar.jsp";
		String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
		
		if (request.getMethod().equals("GET")) {
			
			if (id != ""){
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = new Usuario();
				
				try {
					usuario = usuarioDAO.load(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("usuario", usuario);
			}
			
			
		} else {
			String obs = "";
			
			String nome = request.getParameter("nome").trim() != "" ? request.getParameter("nome").trim() : "";
			String email = request.getParameter("email").trim() !=  "" ? request.getParameter("email").trim() : "";
			String senha = request.getParameter("senha").trim() !=  "" ? request.getParameter("senha").trim() : "";
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			
			if (usuario.getNome() == "") obs = obs + "Informe o nome <br>";
			if (usuario.getEmail() == "") obs = obs + "Informe o email <br>";
			if (usuario.getSenha() == "") obs = obs + "Informe a senha <br>";

			if (obs.equals("")) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				//check is edit/add usuário
				if (id != ""){
					usuario.setId(Integer.parseInt(id));
					usuarioDAO.edit(usuario);
				} else {
					usuarioDAO.add(usuario);
				}
				
				request.setAttribute("usuarios", usuarioDAO.list());
				
				page = "/WEB-INF/usuarioslistar.jsp";
			
			} else {
				request.setAttribute("obs", obs);
				request.setAttribute("usuario", usuario);
			}		
		}
		
		return page;
	}

}
