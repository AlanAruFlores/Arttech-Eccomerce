<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="etiquetas/header.jsp" %>
<link rel="stylesheet" href="css/estiloTabla.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="etiquetas/navbarAdministrador.jsp" %>
	</header>
		
		<h1 class="tituloModificar">Modificar Usuario</h1>
	
		<form action = "modificar-usuario" class="card perfil" style="width: 18rem;" id="cardUsuario" method="get">
		  <img src="image/perfil.JPG" class="card-img-top" alt="imagen perfil" id="cardCuerpoUsuario">
		  <div class="card-body">
				<input type="hidden" name ="id" value="<%=request.getParameter("id")%>" class="form-control"> 
				<input type="text" name="nombre" class="form-control" placeholder="Nuevo nombre" required><br>
				<input type="text" name="email" class="form-control" placeholder="Nuevo email" required><br>
				<button class="btn btn-primary">Modificar</button>
		  </div>
		</form>
<!-- 
	<form action = "modificar-usuario" class="form-inline" method="get">
			<input type="hidden" name ="id" value="<%=request.getParameter("id")%>" class="form-input"> 
			<input type="text" name="nombre" class="form-input">
			<input type="text" name="email" class="form-input">
			<button>Modificar</button>
	</form>
 -->

	<%@include file="etiquetas/footer.jsp" %>

	
</body>
</html>