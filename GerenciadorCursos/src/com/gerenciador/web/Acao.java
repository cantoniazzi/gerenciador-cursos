package com.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	String execute(HttpServletRequest request, HttpServletResponse response);

}