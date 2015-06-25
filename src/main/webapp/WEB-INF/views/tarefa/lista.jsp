<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/imports.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
<title>Gerenciador de Tarefas</title>
</head>
<body>
	<c:import url="../menuNav.jsp" />

	<div class="col-sm-10 col-sm-offset-1">
		<h1 class="page-header">Bem-vindo!</h1>

		<div class="container-fluid">
			<h2 class="sub-header">Lista de Tarefas</h2>

            <div id="alertas">
            </div>

            <div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Descrição</th>
							<th>Concluída?</th>
							<th>Data de Finalização</th>

							<c:if test="${not empty USUARIO_LOGADO}">
								<th></th>
								<th></th>
								<th></th>
							</c:if>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${tarefas}" var="tarefa">
							<tr id="tarefa_${tarefa.id}">
								<td>${tarefa.id}</td>
								<td>${tarefa.descricao}</td>
								<td >
									<c:if test="${tarefa.finalizado eq false}">
										Não
									</c:if>
									<c:if test="${tarefa.finalizado eq true}">
										Sim
									</c:if></td>
								<td>
									<c:if test="${not empty tarefa.dataFinalizacao}">
										<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
											pattern="dd/MM/yyyy" />
									</c:if>
								</td>

								<c:if test="${not empty USUARIO_LOGADO}">
									<td>
										<c:if test="${not tarefa.finalizado}">
											<a href="#" onclick="finalizaAgora(${tarefa.id})">
												Finalizar agora</a>
										</c:if>
									</td>
									<td><a href="#" onclick="confirmaRemocao(${tarefa.id})">Remover</a></td>
									<td><a href="editar?id=${tarefa.id}">Alterar</a></td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<c:if test="${not empty USUARIO_LOGADO}">
				<div class="text-center">
					<a href="adicionar" class="btn btn-primary btn-lg" role="button">Adicionar tarefa</a>
				</div>
			</c:if>

			<c:if test="${empty USUARIO_LOGADO}">
				<div class="text-center">
					<a href="${root}/usuario/login" class="btn btn-primary btn-lg" role="button">Autentique-se</a>
				</div>
			</c:if>
		</div>

		<div id="removerModal" class="modal" role="dialog">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
						<p>Deseja remover esta tarefa?</p>
					</div>
					<div class="modal-footer">
						<button id="confirma-remocao" type="button" class="btn btn-default modal-confirma">Sim</button>
						<button id="recusa-remocao" type="button" class="btn btn-default"
                                onclick="$('#removerModal').modal('hide');">Não</button>
					</div>
				</div>
			</div>
		</div>

		<footer><br /></footer>
	</div>
</body>
</html>