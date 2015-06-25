<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/imports.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='<c:url value="/resources/css/signin.css" />'/>
    <title>Gerenciador de Tarefas</title>
</head>
<body>
<c:import url="../menuNav.jsp"/>

<div class="container">

    <form class="form-signin" action="loga" method="post" role="form">
        <h2 class="form-signin-heading text-center">Autentique-se</h2>

        <div class="input-group">
	        <span class="input-group-addon" id="imagem-conta">
	            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	        </span>
	        <input type="text" name="login" class="form-control"
	        placeholder="Usuário" aria-describedby="imagem-conta" required autofocus>
        </div>

        <div class="input-group">
            <span class="input-group-addon" id="imagem-senha">
                <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
            </span>
            <input type="password" name="senha" class="form-control"
            placeholder="Senha" aria-describedby="imagem-senha" required>
        </div>

        <div class="text-center">
            <h5>
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            <a href="cadastro"> Criar nova conta</a>
            </h5>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>

</div>

</body>
</html>
