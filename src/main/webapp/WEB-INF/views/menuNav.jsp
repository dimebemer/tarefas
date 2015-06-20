<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Navegação</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listaTarefa">Gerenciador de Tarefas</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listaTarefa">Início</a></li>
					<li><a href="${empty usuarioLogado ? 'loginUsuario' : 'novaTarefa'}">
						Adicionar
						</a>
					</li>

                    <c:if test="${empty usuarioLogado}">
                        <li><a href="loginUsuario">Login</a></li>
                        <li><a href="novoUsuario">Cadastro</a></li>
                    </c:if>
                    <c:if test="${not empty usuarioLogado}">
                        <li><a href="#">Perfil</a></li>
                        <li><a href="#">Ajuda</a></li>
                    </c:if>
				</ul>
				<form action="procuraTarefa" class="navbar-form navbar-right">
					<input name="descricao" type="text" class="form-control" placeholder="Procurar...">
				</form>
			</div>
		</div>
	</nav>