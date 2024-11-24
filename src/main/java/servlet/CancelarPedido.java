package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import classes.Usuario;
import classesDao.PedidoDAO;
import datos.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import classes.*;
import classesDao.*;
import datos.Conexion;

/**
 * Servlet implementation class CancelarPedido
 */
public class CancelarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idPedido  = Integer.parseInt(request.getParameter("id"));
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if(usuario != null) {
				PedidoDAO dao = new PedidoDAO(Conexion.getConnection());
				dao.eliminarPedido(idPedido);
				response.sendRedirect("pedidos.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
