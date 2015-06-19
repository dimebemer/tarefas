<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<div class="col-sm-6 col-sm-offset-3">
		<h1 class="page-header">Adicionar tarefa</h1>

		<div class="container-fluid">
			<form method="post" action="adicionaTarefa" role="form">
				<div class="form-group">
					<div>Descrição:</div>
					<div>
						<textarea class="form-control" name="descricao" rows="5"
							cols="100"></textarea>
					</div>
					<div>
						<form:errors path="tarefa.descricao" cssStyle="color:red" />
					</div>
				</div>
				<button type="submit" class="btn btn-default">Adicionar</button>
			</form>
		</div>
	</div>
</body>
</html>