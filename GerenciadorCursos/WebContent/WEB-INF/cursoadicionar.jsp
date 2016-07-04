<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Curso Adicionar</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/rvfs.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top: 50px;">
		<c:if test="${not empty obs}">
		    <div align="center" class="alert alert-danger" style="text-align:center;">
	            <strong>${obs}</strong>
	        </div>	
		</c:if>
		<form class="form-horizontal" action="Controller?acao=CursoAdicionar" method="POST">
			<input type="hidden" name="id" value="${curso.getId()}" />
			<div class="form-group">
			    <label class="control-label col-sm-2" for="nome">Nome:</label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="nome" name="nome" placeholder="Informe o nome" value="${curso.getNome()}">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="requisito">Requisitos:</label>
			    <div class="col-md-6">
			    	<textarea class="form-control" id="requisito" name="requisito" placeholder="Informe os requisitos" rows="4">${curso.getRequisito()}</textarea>
			    </div>
		  	</div>
			<div class="form-group">
			    <label class="control-label col-sm-2" for="cargaHoraria">Carga Horária:</label>
			    <div class="col-md-6">
			    	<input type="text" class="form-control" id="cargaHoraria" name="cargaHoraria" value="${curso.getCargaHoraria()}" placeholder="Informe a carga horária">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="preco">Preço:</label>
			    <div class="col-md-6">
			    	<input type="text" class="form-control" id="preco" name="preco" value="${curso.getPreco()}" placeholder="Informe o preço">
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
	<script type="text/javascript" src="js/store.min.js"></script>
	<script type="text/javascript" src="js/rv-jquery-fontsize.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</body>
</html>