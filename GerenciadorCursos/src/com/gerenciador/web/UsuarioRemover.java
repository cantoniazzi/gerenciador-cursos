package com.gerenciador.web;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.dao.UsuarioDAO;
import com.gerenciador.model.Usuario;

public class UsuarioRemover implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/usuarioremover.jsp";
		String id = request.getParameter("id").trim();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();

		if (id != ""){
			
			try {
				usuario = usuarioDAO.load(Integer.parseInt(id));
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
			
			
			if (request.getMethod().equals("GET"))
				request.setAttribute("usuario", usuario);
		}
		
		if (request.getMethod().equals("POST")) {
			if (id != ""){
				usuarioDAO.delete(usuario);
				request.setAttribute("usuarios", usuarioDAO.list());
				page = "/WEB-INF/usuarioslistar.jsp";
			}
			
		}
		
		
		return page;
	}

}
