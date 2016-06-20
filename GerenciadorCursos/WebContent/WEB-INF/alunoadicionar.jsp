<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos de Extensão - Aluno Adicionar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top: 50px;">
	<h3 class="page-header">Adicionar Aluno</h3>
	<% 
	if (!obs.isEmpty()) {
	%>
	<div align="center" class="alert alert-danger" style="text-align:center;">
	    <strong>É necessário informar o nome</strong>
	</div>
	<%}%>
	<form action="medicosadicionar.jsp" method="POST">
	    <!-- area de campos do form -->
	<hr />
	<div class="row">
	    <div class="form-group col-md-4">
	        <label for="campo3">Nome</label>
	        <input type="text" name="nome" class="form-control" value="<%=medico.getNome()%>">
	            </div>
	        </div>
	        <div id="actions" class="row">
	            <div class="col-md-12">
	                <input type="submit" name="submit" value="Salvar" class="btn btn-primary" />
	                <a href="medicoslistar.jsp" class="btn btn-default">Cancelar</a>
	            </div>
	        </div>
	    </form>
	</div>







	<c:import url="footer.jsp"></c:import>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</body>
</html>