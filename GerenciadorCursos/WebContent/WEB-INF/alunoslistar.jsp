<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Alunos Listar</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/rvfs.css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container-fluid" style="margin-top:50px;">
        <div id="list" class="row">
            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr><td colspan="3"></td></tr>
                        <tr>
                            <td colspan="3"><h3></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <a href="Controller?acao=AlunoAdicionar" class="btn btn-success">Adicionar Aluno</a>
                            </td>
                        </tr>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Email</th>
                            <th>Fone</th>
                            <th>Data Matrícula</th>
                            <th></th>
                            <th></th>
                         </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="aluno" items="${alunos}">
                        	<tr>
	                            <td>${aluno.getId()}</td>
	                            <td>${aluno.getNome()}</td>
	                            <td>${aluno.getCpf()}</td>
	                            <td>${aluno.getEmail()}</td>
                        		<td>${aluno.getFone()}</td>
                        		<td>${aluno.getDataNascimento()}</td>
                        		<td>
	                            	<a href="Controller?acao=AlunoAdicionar&id=<c:out value="${aluno.getId()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
	                            </td>
                            	<td>
                            		<a href="Controller?acao=AlunoRemover&id=<c:out value="${aluno.getId()}"/>"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:import url="footer.jsp"></c:import>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/store.min.js"></script>
	<script type="text/javascript" src="js/rv-jquery-fontsize.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>