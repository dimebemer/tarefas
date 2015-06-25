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

	<div class="col-sm-6 col-sm-offset-3">
		<h1 class="page-header">Editar tarefa</h1>

		<div class="container-fluid">
			<form action="alteraTarefa" method="post" role="form">
				<input class="form-control" name="id" type="hidden"
					value="${tarefa.id}" />

				<div class="form-group">
					<div>
						<label for="descricao">Descrição:</label>
					</div>
					<div>
						<textarea class="form-control" id="descricao" name="descricao"
							rows="5" cols="100">${tarefa.descricao}</textarea>
					</div>
				</div>

				<div class="form-group">
					<div>Data de finalização:</div>
					<div>
						<input class="form-control" type="text" name="dataFinalizacao"
							value='<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />' />
					</div>
				</div>

				<div class="checkbox">
					<label><input name="finalizado" type="checkbox"
						value="true" ${tarefa.finalizado ? 'checked' : ''} /> Finalizada?</label>
				</div>
				<div>
					<button type="submit" class="btn btn-default">Alterar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>