<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="datos.*"%>    
<%@ page import="classes.*" %>
<%@ page import="classesDao.*" %>
<%@ page import="java.util.*" %>
    <%
    Usuario usuarioLogeado = (Usuario)request.getSession().getAttribute("usuario");
	if(usuarioLogeado!= null){
		request.setAttribute("usuarioLogeado", usuarioLogeado); // esto con el fin de establecer una variable global
	}else{
		response.sendRedirect("index.jsp");
	}
	UsuarioDAO dao = new UsuarioDAO(Conexion.getConnection());

	List<Usuario> usuariosRegistrados =dao.getUsuarios(usuarioLogeado);

    %>

<!DOCTYPE html>
<html>
<head>
<%@include file="etiquetas/header.jsp"%>
<link rel="stylesheet" href="css/estiloTabla.css">

<title>Panel de Usuario</title>
</head>
<body>
<header>
<%@include file="etiquetas/navbarAdministrador.jsp"%>
</header>
<br>
	<div class="container">
		<h1>Panel de Usuario</h1>
	</div>
	
		<table class=" container table table-loght">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Email</th>
					<th scope="col">Modificar</th>
					<th scope="col">Expulsar</th>
				</tr>
			</thead>
			<tbody>
			<%if (usuariosRegistrados.size()>0){ %>
				<% for(Usuario user : usuariosRegistrados){%>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getNombre() %></td>
					<td><%=user.getEmail() %></td>
					<td>
						<a class = "btn btn-primary" href="EditarUsuario.jsp?id=<%=user.getId()%>">Modificar</a>
					</td>
					<td>
						<a class = "btn btn-danger" href="eliminar-usuario?id=<%=user.getId()%>">Eliminar</a>
					</td>
				</tr>
				<%} 
				}%>		
			</tbody>
		</table>


<%@include file="etiquetas/footer.jsp"%>
</body>
</html>