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
        <h2 class="form-signin-heading">Cadastro</h2>
        <label for="login" class="sr-only">Nome de usuário</label>
        <input type="text" name="login" id="login" class="form-control" placeholder="Usuário" required autofocus>

        <label for="senha" class="sr-only">Senha</label>
        <input type="password" name="senha" id="senha" class="form-control" />

        <label for="confirmarSenha" class="sr-only">Confirme sua senha</label>
        <input type="password" name="confirmarSenha" id="confirmarSenha" class="form-control" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Criar cadastro</button>
    </form>

</div>

</body>
</html>
