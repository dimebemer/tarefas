<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='<c:url value="/resources/css/bootstrap.min.css" />' />
<link rel='stylesheet'
	href='<c:url value="/resources/css/bootstrap-theme.min.css" />'>
<link rel='stylesheet'
	href='<c:url value="/resources/css/dashboard.css" />' />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Gerenciador de Tarefas</title>
</head>
<body>
	<c:import url="../menuNav.jsp" />

	<div class="col-sm-12 text-center">
		<div class="container-fluid">
			<h3 class="sub-header text-success">Usuário cadastrado com sucesso!</h3>
			<a href="listaTarefa" class="btn btn-primary" role="button">Abrir tarefas</a>
		</div>
	</div>
</body>
</html>