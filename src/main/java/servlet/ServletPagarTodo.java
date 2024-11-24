package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import classes.Carrito;
import classes.Pedido;
import classes.Usuario;
import classesDao.PedidoDAO;
import datos.Conexion;

/**
 * Servlet implementation class ServletPagarTodo
 */
public class ServletPagarTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagarTodo() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = new Date();
			ArrayList<Carrito> carrito = (ArrayList<Carrito>)request.getSession().getAttribute("carrito-lista");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			if(carrito!=null && usuario != null) {
				for(Carrito c : carrito) {
					Pedido pedido = new Pedido(c.getId(), usuario.getId(), c.getCantidad(), formato.format(fecha));
					PedidoDAO dao = new PedidoDAO(Conexion.getConnection());
					boolean value =dao.insertarPedido(pedido);
				}
				carrito.clear();
				response.sendRedirect("pedidos.jsp");
			}else {
				if(usuario==null) response.sendRedirect("login.jsp");
				response.sendRedirect("Carrtio.jsp");
			}
		}catch(Exception ex) {
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
