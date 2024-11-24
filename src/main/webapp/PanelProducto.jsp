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
	ProductoDAO dao = new ProductoDAO(Conexion.getConnection());
	List<Producto> listProductos = dao.getListaProductos2();
	
%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="etiquetas/header.jsp"%>
	<link rel="stylesheet" href="css/estiloTabla.css">
	<title>Panel de Productos</title>
</head>
<body>
<header>
	<%@include file="etiquetas/navbarAdministrador.jsp"%>
</header>
<br>
	<div class="container">
		<h1>Panel de Productos</h1>
	</div>		<table class="container table table-loght">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Producto</th>
					<th scope="col">Precio</th>
					<th scope="col">Modificar</th>
					<th scope="col">Expulsar</th>
					
				</tr>
			</thead>
			<tbody>
			<%if (listProductos.size()>0){ %>
				<% for(Producto prod : listProductos){%>
				<tr>
					<td><%=prod.getId() %></td>
					<td><%=prod.getNombre()%></td>
					<td>$<%=prod.getPrecio()%></td>
					<td>
						<a class = "btn btn-primary" href="EditarProducto.jsp?id=<%=prod.getId()%>">Modificar</a>
					</td>
					<td>
						<a class = "btn btn-danger" href="eliminar-producto-db?id=<%=prod.getId()%>">Eliminar</a>
					</td>
				</tr>
				<%} 
				}%>		
			</tbody>
		</table>
		<%@include file="etiquetas/footer.jsp"%>
</body>
</html>