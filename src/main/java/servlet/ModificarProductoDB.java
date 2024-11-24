package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import classes.*;
import classesDao.*;
import datos.Conexion;
/**
 * Servlet implementation class ModificarProductoDB
 */
public class ModificarProductoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductoDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			
			if(request.getSession().getAttribute("usuario")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				double precio = Double.parseDouble(request.getParameter("precio"));	
				Producto producto = new Producto(id,precio,nombre);
				ProductoDAO dao = new ProductoDAO(Conexion.getConnection());
				dao.modificarProducto(producto);
				response.sendRedirect("PanelProducto.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
