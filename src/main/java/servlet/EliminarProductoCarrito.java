package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import classes.Carrito;

/**
 * Servlet implementation class EliminarProductoCarrito
 */
public class EliminarProductoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");			
			if(id != null) {
				int idCarrito = Integer.parseInt(id);
				ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito-lista");
				for(Carrito prod : listaCarrito) {
					if(prod.getId() == idCarrito) {
						listaCarrito.remove(prod);
						break;
					}
				}
				response.sendRedirect("Carrtio.jsp");
			}else {
				response.sendRedirect("Carrtio.jsp");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
