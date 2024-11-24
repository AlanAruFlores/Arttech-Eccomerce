<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>
<%@ page import ="classesDao.*" %>
<%@ page import ="datos.*" %>
<%
	Usuario usuarioLogeado = (Usuario)request.getSession().getAttribute("usuario");
	if(usuarioLogeado== null){
		response.sendRedirect("index.jsp");
	}
	
	
	ArrayList<Carrito>lista_carrito = (ArrayList<Carrito>)session.getAttribute("carrito-lista");
	List<Carrito> carrito = null;
	double importe =0;
	if(lista_carrito != null){
		ProductoDAO dao = new ProductoDAO(Conexion.getConnection());
	    importe = dao.getTotalImporte(lista_carrito);
		carrito = dao.getListaCarrito(lista_carrito);
		request.setAttribute("lista_carrito", lista_carrito);
		request.setAttribute("total", importe);
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<%@include file="etiquetas/header.jsp" %>
	<link rel="stylesheet" href="css/estiloTabla.css">
<style>
	#inputCantidad{
		width:100px;
	}
</style>
</head>
<body>
	<header>
		<%@ include file="etiquetas/navbar.jsp" %>
	</header>
	
	<div class="container">
		<div class="d-flex py-3">
			<h1>Importe total: $ ${(total>0)?total:0}</h1>
			<a href="pagar-todo" ><button class="btn btn-danger botonPagar">Pagar Todo</button></a>
		</div>
		
		
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Producto</th>
					<th scope="col">Categoria</th>
					<th scope="col">Precio</th>
					<th scope="col">Comprar</th>
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody>
			<%if (lista_carrito != null){ %>
				<% for(Carrito carr : carrito){%>
				<tr>
					<td><%=carr.getNombre() %></td>
					<td><%=carr.getCategoria() %></td>
					<td><%=carr.getPrecio() %></td>
					<td>
						<form action = "agregar-pedido" class="form-inline" method="POST">
							<input type="hidden" name ="id" value=<%=carr.getId() %> class="form-input"> <!-- id Producto oculto -->	
							<div class="form-group d-flex justify-content-center">
								<a href="s-crec-dec?accion=inc&id=<%=carr.getId() %>" class="btn btn-sm btn-menos" id="idPlus"><i class="fas fa-plus-square" ></i></a>
								<input id ="inputCantidad" type="text" name="cantidad" class=" w-10 form-control " value=<%=carr.getCantidad()%> readonly> <!-- cantidad -->	
								<a href="s-crec-dec?accion=dec&id=<%=carr.getId() %>" class="btn btn-sm btn-suma" id="idMinus"><i class="fas fa-minus-square" ></i></a>
							    <span><button class="btn btn-primary">Comprar</button></span>
							</div>
						</form>
					</td>
					<td>
						<a class = "btn btn-danger" href="eliminar-carrito?id=<%=carr.getId()%>">Eliminar</a>
					</td>
				</tr>
				<%} 
				}%>		
			</tbody>
		</table>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<%@ include file="etiquetas/footer.jsp" %>
</body>
</html>