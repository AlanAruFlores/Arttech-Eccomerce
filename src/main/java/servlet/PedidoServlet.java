package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import classes.*;
import classesDao.*;
import datos.*;

/**
 * Servlet implementation class PedidoServlet
 */
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			Date fecha = new Date();
			if(usuario != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));
				if(cantidad<1) {
					cantidad = 1;
				}
				
				Pedido pedido = new Pedido(id,usuario.getId(), cantidad, formato.format(fecha));
				PedidoDAO dao = new PedidoDAO(Conexion.getConnection());
				boolean value = dao.insertarPedido(pedido);
				if(value) {
					borrarProductoCarrito(id, request);
				}
			}else {
				response.sendRedirect("login.jsp");
			}
			response.sendRedirect("Carrtio.jsp");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private void borrarProductoCarrito(int id, HttpServletRequest request) {
		ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito-lista");
		if(id > 0) {
			for(Carrito prod : listaCarrito) {
				if(prod.getId() == id) {
					listaCarrito.remove(prod);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
