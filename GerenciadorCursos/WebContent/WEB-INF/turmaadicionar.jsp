<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Turma Adicionar</title>
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
		<h3 class="page-header">Adicionar Turma</h3>
		<c:if test="${not empty obs}">
		    <div align="center" class="alert alert-danger" style="text-align:center;">
	            <strong>${obs}</strong>
	        </div>	
		</c:if>
		<form class="form-horizontal" action="Controller?acao=TurmaAdicionar" method="POST">
			<input type="hidden" name="id" value="${turma.getId()}" />
			<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Instrutor:</label>
			    <div class="col-md-6"> 
		    		<select name="instrutorId" class="form-control">
					    <c:forEach var="instrutor" items="${instrutores}">
					        <option value="${instrutor.getId()}" ${instrutor.getId() == turma.getInstrutor().getId() ? 'selected="selected"' : ''}>${instrutor.getNome()}</option>
					    </c:forEach>
					</select>  
		      	</div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Curso:</label>
			    <div class="col-md-6">
				    <select name="cursoId" class="form-control">
					    <c:forEach var="curso" items="${cursos}">
					        <option value="${curso.getId()}" ${curso.getId() == turma.getCurso().getId() ? 'selected="selected"' : ''}>${curso.getNome()}</option>
					    </c:forEach>
					</select>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Data Início:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="dataInicio" name="dataInicio" value="${turma.getDataInicio()}" placeholder="Informe a data de início">
			    </div>
		  	</div>
			<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Data Fim:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="dataFim" name="dataFim" value="${turma.getDataFim()}" placeholder="Informe a data fim">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Carga Horária:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="cargaHoraria" name="cargaHoraria" value="${turma.getCargaHoraria()}" placeholder="Informe a carga horária">
			    </div>
		  	</div>
		  	<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
			  		<input type="submit" name="submit" value="Salvar" class="btn btn-primary" />
	                <a href="javascript:window.history.back();" class="btn btn-default">Cancelar</a>
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