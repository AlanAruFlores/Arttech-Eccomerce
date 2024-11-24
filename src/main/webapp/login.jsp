<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.Usuario" %>
    <%
	Usuario usuarioLogeado = (Usuario)request.getSession().getAttribute("usuario");
	if(usuarioLogeado!= null){
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Login Cliente</title>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alumni+Sans+Pinstripe&display=swap" rel="stylesheet">
    <link rel="icon" href="img/logo_00remove-removebg-preview.png">
    <title>Log In</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<header>
        <h1>ARTTECH</h1>
    </header>
        <form action="user-login" method="post">
            <label for="">Correo</label>
            <input type="email" placeholder="correo electrónico" id="usuario" name ="mail" required>
            <label for="">Contraseña</label>
            <input type="password" placeholder="******" id="contrasenia" name="contrasenia" required> 
            <a href="registro.jsp">No tenes una cuenta? Registrate Ya</a>
            <button>INGRESAR</button>
            <span class="error"></span>
        </form>
    <footer>
        <img src="img/logo_00remove-removebg-preview.png" alt="">
    </footer>
	<%@include file="etiquetas/footer.jsp"%>
</body>
</html>
