<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Aluno Remover</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/rvfs.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top: 50px;">
		<h3 class="page-header">Remover Curso</h3>
	    <div align="center" class="alert alert-danger" style="text-align:center;">
            Você deseja realmente remover o aluno <strong><c:out value="${aluno.getNome()}"/> ?</strong>
        </div>	
		<form class="form-horizontal" action="Controller?acao=AlunoRemover" method="POST">
			<input type="hidden" name="id" value="${aluno.getId()}" />
		  	<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10 text-center">
			  		<input type="submit" name="submit" value="Remover" class="btn btn-primary" />
	                <a href="javascript:window.history.back();" class="btn btn-default">Cancelar</a>
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