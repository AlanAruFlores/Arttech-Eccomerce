package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import classes.Carrito;
import classes.Producto;
import classes.*;
import java.util.*;
import java.io.*;
/**
 * Servlet implementation class AñadirCarrito
 */
public class AñadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // crea un archivo html
		try(PrintWriter out =response.getWriter()){
				HttpSession session = request.getSession();
				if(session.getAttribute("usuario") != null) {
					ArrayList<Carrito> lista = new ArrayList<Carrito>();
					int id = Integer.parseInt(request.getParameter("id"));
					Carrito carrito = new Carrito(id, 1);
					
					ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>)session.getAttribute("carrito-lista");
					
					if(listaCarrito==null) {
						lista.add(carrito);
						session.setAttribute("carrito-lista", lista);
						response.sendRedirect("index.jsp");
					}else {
						lista = listaCarrito;
						boolean existeProducto = false;
						
						for(Producto producto : lista) {
							if(producto.getId() == id) {
								response.sendRedirect("Carrtio.jsp");
								existeProducto = true;
								break;
							}
						}
						if(!existeProducto) {
							response.sendRedirect("index.jsp");
							lista.add(carrito);
						}		
					}
				}else {
					response.sendRedirect("login.jsp");
				}
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	
	}
}
