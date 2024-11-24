package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import classes.Carrito;

/**
 * Servlet implementation class ServletCrecDrec
 */
public class ServletCrecDrec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrecDrec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String accion = request.getParameter("accion");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito-lista");
			
			if(accion != null && id > 0) {
				if(accion.equals("inc")) {
					for(Carrito prod : carrito) 
						if(prod.getId() == id) {
							prod.setCantidad(1);
						}
				}
				else {
					for(Carrito prod : carrito) {
						if(prod.getId() == id && prod.getCantidad()>0) 
						{
							prod.setCantidad(-1);
						}
					}
				}		
			}
			
			response.sendRedirect("Carrtio.jsp");

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
