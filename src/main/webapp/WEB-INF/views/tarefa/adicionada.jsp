<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/imports.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gerenciador de Tarefas</title>
</head>
<body>
	<c:import url="../menuNav.jsp" />

	<div class="col-sm-12 text-center">
		<div class="container-fluid">
			<h3 class="sub-header text-success">Tarefa adicionada com sucesso!</h3>
			<a href="listaTarefa" class="btn btn-primary" role="button">Abrir tarefas</a>
		</div>
	</div>
</body>
</html>