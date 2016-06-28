<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos de Extensão - Matrículas Listar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	
	<div id="main" class="container-fluid" style="margin-top:50px;">
        <div id="list" class="row">
            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <td colspan="3"><h3>Matrículas - Listar</h3></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <a href="Controller?acao=MatriculaAdicionar" class="btn btn-success">Adicionar Matrícula</a>
                            </td>
                        </tr>
                        <tr>
                            <th>ID</th>
                            <th>Turma</th>
                            <th>Aluno</th>
                            <th>Data Matrícula</th>
                            <th></th>
                            <th></th>
                         </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="matricula" items="${matriculas}">
                        	<tr>
	                            <td>${matricula.getId()}</td>
	                            <td>${turma.getTurma().getId()}</td>
                            	<td>${turma.getAluno().getNome()}</td>
	                            <td>${turma.getDataMatricula()}</td>
	                            <td>
	                            	<a href="Controller?acao=MatriculaAdicionar&id=<c:out value="${matricula.getId()}"/>">
	                            		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            		</a>
	                            </td>
                            	<td>
                            		<a href="Controller?acao=MatriculaRemover&id=<c:out value="${matricula.getId()}"/>">
                            			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                           			</a>
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
</body>
</html>