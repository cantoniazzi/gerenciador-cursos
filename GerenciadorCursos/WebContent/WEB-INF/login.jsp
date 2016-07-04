<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cursos de Extensão - Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="/WEB-INF/css/style.css">
</head>
<body>
	<div class="container">    
    	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
       		<div class="panel panel-info">
       			<c:if test="${not empty obs}">
				    <div align="center" class="alert alert-danger" style="text-align:center;">
                    <strong>${obs}</strong>
                </div>	
				</c:if>
				<div class="panel-heading">
                    <div class="panel-title">Entrar no sistema</div>
                 </div>
                 <div style="padding-top:30px" class="panel-body" >
                     <form id="loginform" class="form-horizontal" role="form" method="POST" action="Controller">
                         <input type="hidden" name="acao" value="Login" />
                         <div style="margin-bottom: 25px" class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                             <input id="login-username" type="text" class="form-control" name="email" value="" placeholder="username or email">                                        
                         </div>
                         <div style="margin-bottom: 25px" class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                             <input id="login-password" type="password" class="form-control" name="senha" placeholder="password">
                         </div>
                         <div style="margin-top:10px" class="form-group">
                             <div class="col-sm-12 controls">
                               <input type="submit" name="submit" class="btn btn-success" value="Login"/>
                             </div>
                         </div>   
                     </form>
                 </div>
			</div>
        </div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>   
</body>
</html>