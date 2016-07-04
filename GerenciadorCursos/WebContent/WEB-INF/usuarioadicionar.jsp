<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Usuário Adicionar</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/rvfs.css" />
</head>
<body id="bodySystem">
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top: 50px;">
		<h3></h3>
		<h3></h3>
		<c:if test="${not empty obs}">
		    <div align="center" class="alert alert-danger" style="text-align:center;">
	            <strong>${obs}</strong>
	        </div>	
		</c:if>
		<form class="form-horizontal" action="Controller?acao=UsuarioAdicionar" method="POST">
			<input type="hidden" name="id" value="${usuario.getId()}" />
			<div class="form-group">
			    <label class="control-label col-sm-2" for="nome"><p>Nome:</p></label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="nome" name="nome" placeholder="Informe o nome" value="${usuario.getNome()}">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="nome"><p>Email:</p></label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="email" name="email" placeholder="Informe o email" value="${usuario.getEmail()}">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="nome"><p>Senha:</p></label>
			    <div class="col-md-6">
					<input type="text" class="form-control" id="senha" name="senha" placeholder="Informe a senha" value="${usuario.getSenha()}">
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
	<script type="text/javascript" src="js/store.min.js"></script>
	<script type="text/javascript" src="js/rv-jquery-fontsize.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</body>
</html>