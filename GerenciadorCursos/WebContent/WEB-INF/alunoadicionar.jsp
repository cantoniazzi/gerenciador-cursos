<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Aluno Adicionar</title>
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
		<form class="form-horizontal" action="Controller?acao=AlunoAdicionar" method="POST">
			<input type="hidden" name="id" value="${aluno.getId()}" />
			<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Nome:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="nome" name="nome" value="${aluno.getNome()}" placeholder="Informe o nome">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">CPF:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="cpf" name="cpf" value="${aluno.getCpf()}" placeholder="Informe o cpf">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-md-6">
			      <input type="email" class="form-control" id="email" name="email" value="${aluno.getEmail()}" placeholder="Informe o email">
			    </div>
		  	</div>
			<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Fone:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="email" name="fone" value="${aluno.getFone()}" placeholder="Informe o fone">
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="email">Data Nascimento:</label>
			    <div class="col-md-6">
			      <input type="text" class="form-control" id="dataNascimento" name="dataNascimento" value="${aluno.getDataNascimento()}" placeholder="Informe a data de nascimento">
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