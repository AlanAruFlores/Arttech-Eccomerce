package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import classes.Carrito;
import classesDao.ProductoDAO;
import datos.Conexion;

/**
 * Servlet implementation class EliminarProductoDB
 */
public class EliminarProductoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));		
			ProductoDAO dao = new ProductoDAO(Conexion.getConnection());
			dao.eliminarProducto(id);
			response.sendRedirect("PanelProducto.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
