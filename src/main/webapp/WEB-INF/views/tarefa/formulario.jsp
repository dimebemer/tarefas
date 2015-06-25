<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/imports.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Gerenciador de Tarefas</title>
</head>
<body>
	<c:import url="../menuNav.jsp" />
	<div class="col-sm-6 col-sm-offset-3">
		<h1 class="page-header">Adicionar tarefa</h1>

		<div class="container-fluid">
			<form method="post" action="adiciona" role="form">
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