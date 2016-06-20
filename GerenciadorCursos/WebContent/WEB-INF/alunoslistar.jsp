<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos de Extensão - Alunos Listar</title>
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
                            <td colspan="3"><h3>Alunos - Listar</h3></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <a href="Controler?acao=AlunoAdicionar" class="btn btn-success">Adicionar Aluno</a>
                            </td>
                        </tr>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Email</th>
                            <th>Fone</th>
                         </tr>
                    </thead>
                    <tbody>
                        <c:forEach begin="0" end="20" var="i">
                        	<tr>
	                            <td>3223</td>
	                            <td>Aluno <c:out value="${i}"/></td>
	                            <td>82377823</td>
	                            <td>aluno<c:out value="${i}"/>@aluno.com.br</td>
	                            <td>32243343434</td>
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