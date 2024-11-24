
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
	}
	
	List<Producto> listaProductos = new ProductoDAO(Conexion.getConnection()).getListaProductos2();
	
	ArrayList<Carrito>lista_carrito = (ArrayList<Carrito>)session.getAttribute("carrito-lista");
	
	if(lista_carrito != null){
		request.setAttribute("lista_carrito", lista_carrito);
		
	}
	List<Producto> listaAutos = new ArrayList<Producto>();
	List<Producto> listaJuegos = new ArrayList<Producto>();
	List<Producto> listaAseo = new ArrayList<Producto>();
	
		for(Producto prod : listaProductos){
			if(prod.getCategoria().equals("Transporte")){
				listaAutos.add(prod);
			}
		}
		for(Producto prod : listaProductos){
			if(prod.getCategoria().equals("Cuidado Personal")){
				listaJuegos.add(prod);
			}
		}
		for(Producto prod : listaProductos){
			if(prod.getCategoria().equals("Videojuego")){
				listaAseo.add(prod);
			}
		}
		
		
	%>
<!DOCTYPE html>
<html>
<head>
<title>Inicio SupeMarket</title>
	<%@include file="etiquetas/header.jsp" %>
	
</head>
<body>
	<header>
		<%@ include file ="etiquetas/navbar.jsp" %>
	</header>
	<section id="Portada">
        <!-- <h3>Productos Destacados</h3>-->
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="img/portada 00.jpeg" class="d-block w-100" alt="banner 1">
              </div>
              <div class="carousel-item">
                <img src="img/portada 04.jpg" class="d-block w-100" alt="banner 2">
              </div>
              <div class="carousel-item">
                <img src="img/portada 05.jpg" class="d-block w-100" alt="banner 3">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    </section>

    <section id="Filtros">
      
      <div class="contenedor">
        <div class="box">
          <img src="img/auto.jpg" alt="">
          <a href="#filaVehiculos"><button type="button" class="btn">Vehiculos</button></a>
        </div>
        <div class="box">
          <img src="img/mando.jpg" alt="">
          <a href="#filaVideojuegos"><button type="button" class="btn">Consolas y Videojuegos</button></a>
        </div>
        <div class="box">
          <img src="img/cuidado.jpg" alt="">
          <a href="#filaAseo"><button type="button" class="btn">Belleza y Cuidado Personal</button></a>
        </div>
      </div>
        
    </section>

    <section id="Productos">
      <div class="mostrador" id="mostrador">
          <div class="fila" id="filaVehiculos">
          	 <%for(Producto prod : listaAutos){%>
              <div class="item" onclick="cargar(this)">
                  <div class="contenedor-foto">
                      <img src="imagenProducto/<%=prod.getImagen()%>" alt="imagen">
                  </div>
                  <p class="descripcion"><%=prod.getNombre()%></p><br>
                  <span class="precio">USD <%=prod.getPrecio()%></span><br>
                  <a href="añadir-carrito?id=<%=prod.getId()%>" class="btn btn-danger">Añadir Carrito</a>
              </div>
              <%} %>              
          </div>
          <br>
          <br>
          <br>
           <div class="fila" id="filaAseo">
          	 <%for(Producto prod: listaAseo){ %>
              <div class="item" onclick="cargar(this)">
                  <div class="contenedor-foto">
                      <img src="imagenProducto/<%=prod.getImagen()%>" alt="imagen">
                  </div>
                  <p class="descripcion"><%=prod.getNombre()%></p><br>
                  <span class="precio">USD <%=prod.getPrecio()%></span><br>
                  <a href="añadir-carrito?id=<%=prod.getId()%>" class="btn btn-danger">Añadir Carrito</a>
              </div>
              <%} %>              
          </div>
          <br>
          <br>
          <br>
           <div class="fila" id="filaVideojuegos">
          	 <%for(Producto prod: listaJuegos){ %>
              <div class="item" onclick="cargar(this)">
                  <div class="contenedor-foto">
                      <img src="imagenProducto/<%=prod.getImagen()%>" alt="imagen">
                  </div>
                  <p class="descripcion"><%=prod.getNombre()%></p><br>
                  <span class="precio">USD <%=prod.getPrecio()%></span><br>
                  <a href="añadir-carrito?id=<%=prod.getId()%>" class="btn btn-danger">Añadir Carrito</a>
                  
              </div>
              <%} %>              
          </div>
      </div>
  </section>
            <br>
          <br>
          <br>
  	<%@include file="etiquetas/footer.jsp" %>
</body>
</html>


	