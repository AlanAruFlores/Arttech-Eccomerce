<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<%@ page import="datos.*" %>
<%@ page import="java.util.*" %>
<%@ page import="classesDao.*" %>
<%
	Usuario usuarioLogeado = (Usuario)request.getSession().getAttribute("usuario");
	List<Pedido> listaPedidos = null;
	
	if(usuarioLogeado== null){
		response.sendRedirect("index.jsp");
		
	}else{
		request.setAttribute("usuario", usuarioLogeado);
		PedidoDAO dao = new PedidoDAO(Conexion.getConnection());
	    listaPedidos = dao.listaPedidos(usuarioLogeado.getId());
	}
	ArrayList<Carrito>lista_carrito = (ArrayList<Carrito>)session.getAttribute("carrito-lista");
	
	if(lista_carrito != null){
		request.setAttribute("lista_carrito", lista_carrito);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="etiquetas/header.jsp" %>
	<link rel="stylesheet" href="css/estiloTabla.css">
	<title>Pedidos</title>
</head>
<body>
	<header>
		<%@ include file="etiquetas/navbar.jsp" %>
	</header>	
		<div class=" container card-header my-3">
			<h1>Pedidos Realizados</h1>
		</div>
		<table class=" container table table-loght">
			<thead>
				<th>Fecha</th>
				<th>Nombre</th>
				<th>Categoria</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Cancel</th>
			</thead>
			<tbody>
				<%if(listaPedidos != null){
					for(Pedido ped : listaPedidos){
					%>
					<tr>
						<td><%=ped.getFecha() %></td>
						<td><%=ped.getNombre()%></td>
						<td><%=ped.getCategoria() %></td>
						<td><%=ped.getCantidad()%></td>
						<td><%=ped.getPrecio()%></td>
						<td><a class="btn btn-sm btn-danger" href="cancelar?id=<%=ped.getIdPedido()%>">Cancelar</a></td>
					</tr>
				<%}
				}%>
			</tbody>
				
		</table>
	
	
	<%@ include file="etiquetas/footer.jsp" %>
</body>
</html>