   <div class="contenedor">
      <a class="logo">
        <img src="img/logo_00remove-removebg-preview.png" alt="logo">
      </a>
      <nav>
     	<%if(usuarioLogeado!=null){ %>
     	  <a href="index.jsp" class="boton">Inicio</a>
     	  <a  href="Carrtio.jsp"class="boton">Carrito <span class="badge bg-danger">${lista_carrito.size()}</span></a>
          <a  href="pedidos.jsp"class="boton">Pedidos</a>
          <a  href="log-out"class="boton">Cerrar Sesion</a>     	

     	
     	<%}else{ %>
        <a href="index.jsp" class="boton">Inicio</a>
		<a href="login.jsp" class="boton">Iniciar Sesion</a>
        <a href="registro.jsp" class="boton">Registrarse</a>
		<%} %>
      </nav>
</div>