<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Cursos de Extensão</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Controller?acao=Inicio">Cursos de Extensão - Administração</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Controller?acao=AlunosListar">Alunos</a></li>
                <li><a href="Controller?acao=InstrutoresListar">Instrutores</a></li>
                <li><a href="Controller?acao=CursosListar">Cursos</a></li>
                <li><a href="Controller?acao=TurmasListar">Turmas</a></li>
                <li><a href="Controller?acao=MatriculasListar">Matrículas</a></li>
                <li><a href="Controller?acao=UsuariosListar">Usuários</a></li>
                <li><a href="Controller?acao=Logout">Sair</a></li>
            </ul>
        </div>
    </div>
</nav>