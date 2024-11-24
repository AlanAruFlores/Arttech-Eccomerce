<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="datos.*"%>    
<%@ page import="classes.*" %>
<%@ page import="classesDao.*" %>
<%@ page import="java.util.*" %>
    <%@ page import="javax.swing.*" %>
    
<%
	Usuario usuarioLogeado = (Usuario)request.getSession().getAttribute("usuario");
	if(usuarioLogeado!= null){
		request.setAttribute("usuarioLogeado", usuarioLogeado); // esto con el fin de establecer una variable global
	}else{
		response.sendRedirect("index.jsp");
	}
	ProductoDAO dao = new ProductoDAO(Conexion.getConnection());
	List<Producto> listProductos = dao.getListaProductos2();
	
	Producto seleccionado = null;
	for(Producto prod : listProductos){
		if(prod.getId() == Integer.parseInt(request.getParameter("id"))){
			seleccionado = prod;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="etiquetas/header.jsp" %>
<link rel="stylesheet" href="css/estiloTabla.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="etiquetas/navbarAdministrador.jsp" %>
	</header>
		
		<h1 class="tituloModificar">Modificar Producto</h1>
	
		<form action = "modificar-producto-db" class="card perfil" style="width: 18rem;" id="cardUsuario" method="get">
		  <img src="imagenProducto/<%=seleccionado.getImagen()%>" class="card-img-top" alt="imagen">
		  <div class="card-body">
				<input type="hidden" name ="id" value="<%=seleccionado.getId()%>" class="form-control" required> 
				<input type="text" name="nombre" class="form-control" placeholder="Nombre del Producto" required>
				<input type="number" name="precio" class="form-control" placeholder="Precio" required>
				<button class="btn btn-primary">Modificar</button>
		  </div>
		</form>
	
	<%@ include file="etiquetas/footer.jsp" %>
	
</body>
</html>