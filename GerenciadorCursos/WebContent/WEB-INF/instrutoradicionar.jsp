<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Instrutor Adicionar</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<style>
		footer {
			position: absolute;
			bottom: 0;
			width: 100%;
			/* Set the fixed height of the footer here */
			height: 60px;
			background-color: #f5f5f5;	
		}
	</style>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top: 50px;">
		<h3 class="page-header">Adicionar Instrutor</h3>
		<c:if test="${not empty obs}">
		    <div align="center" class="alert alert-danger" style="text-align:center;">
	            <strong>${obs}</strong>
	        </div>	
		</c:if>
		<form class="form-horizontal" action="Controller?acao=InstrutorAdicionar" method="POST">
			<input type="hidden" name="id" value="${instrutor.getId()}" />
			<div class="form-group">
			    <label class="control-label col-sm-2" for="nome">Nome:</label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="nome" name="nome" placeholder="Informe o nome" value="${instrutor.getNome()}">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="requisito">Email:</label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="email" name="email" placeholder="Informe o email" value="${instrutor.getEmail()}">
			    </div>
		  	</div>
			<div class="form-group">
			    <label class="control-label col-sm-2" for="cargaHoraria">Valor Hora:</label>
			    <div class="col-md-6">
			    	<input type="text" class="form-control" id="valorHora" name="valorHora" value="${instrutor.getValorHora()}" placeholder="Informe o valor hora">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="preco">Certificados:</label>
			    <div class="col-md-6">
			    	<textarea class="form-control" id="certificados" name="certificados" placeholder="Informe os certificados" rows="4">${instrutor.getCertificados()}</textarea>
			    </div>
		  	</div>
		  	<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
			  		<input type="submit" name="submit" value="Salvar" class="btn btn-primary" />
	                <a href="medicoslistar.jsp" class="btn btn-default">Cancelar</a>
		  		</div>
		    </div>
		    </hr>
		</form>
	</div>
	<c:import url="footer.jsp"></c:import>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</body>
</html>