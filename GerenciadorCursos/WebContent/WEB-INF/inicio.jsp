<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/lib/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos de Extensão - Dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="main" class="container" style="margin-top:50px;">
           <h1 class="page-header">Bem vindo ao Sistema de Cursos</h1>
           <h3>Selecione a opção desejada no menu superior</h3>
           <div class="col-md-6">
           		<iframe width="560" height="315" src="https://www.youtube.com/embed/k6U-i4gXkLM?list=PL57FCE46F714A03BC" frameborder="0" allowfullscreen></iframe>
           </div>
           <div class="col-md-6">
				<iframe width="560" height="315" src="https://www.youtube.com/embed/S3t-5UtvDN0" frameborder="0" allowfullscreen></iframe>	           </div>
       </div>
    <c:import url="footer.jsp"></c:import>
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>