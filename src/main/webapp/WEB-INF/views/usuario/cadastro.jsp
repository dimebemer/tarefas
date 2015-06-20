<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet'
          href='<c:url value="/resources/css/bootstrap.min.css" />'/>
    <link rel='stylesheet'
          href='<c:url value="/resources/css/bootstrap-theme.min.css" />'>
    <link rel='stylesheet'
          href='<c:url value="/resources/css/dashboard.css" />'/>
    <link rel='stylesheet'
          href='<c:url value="/resources/css/signin.css" />'/>
    <script type="text/javascript"
            src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    <script type="text/javascript"
            src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <title>Gerenciador de Tarefas</title>
</head>
<body>
<c:import url="../menuNav.jsp"/>

<div class="container">

    <form class="form-signin" action="cadastraUsuario" method="post" role="form">
        <h2 class="form-signin-heading text-center">Cadastro</h2>

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

        <div class="input-group">
            <span class="input-group-addon" id="imagem-confirma-senha">
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
            </span>
            <input type="password" name="confirmarSenha" class="form-control"
            placeholder="Confirme sua senha" aria-describedby="imagem-confirma-senha" required>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Criar cadastro</button>
    </form>

</div>

</body>
</html>
