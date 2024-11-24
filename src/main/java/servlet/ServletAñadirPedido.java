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

import classes.Carrito;
import classes.Pedido;
import classes.Usuario;
import classesDao.PedidoDAO;
import datos.Conexion;

/**
 * Servlet implementation class ServletAñadirPedido
 */
public class ServletAñadirPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAñadirPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			Date fecha = new Date();
				int id = Integer.parseInt(request.getParameter("id"));
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));
				if(cantidad<1) {
					cantidad = 1;
				}
				
				Pedido pedido = new Pedido(id,usuario.getId(), cantidad, formato.format(fecha));
				PedidoDAO dao = new PedidoDAO(Conexion.getConnection());
				boolean value = dao.insertarPedido(pedido);
				if(value)
				{
					ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito-lista");
					if(listaCarrito != null) {
						for(Carrito carr : listaCarrito) {
							if(carr.getId() == id) {
								listaCarrito.remove(carr);
								break;
							}
						}
						response.sendRedirect("pedidos.jsp");
					}else {
						out.print("Error");
					}
				}else {
					response.sendRedirect("login.jsp");
				}
			
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
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
