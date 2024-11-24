package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Salir
 */
public class Salir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salir() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			if(request.getSession().getAttribute("usuario") != null) {
				request.getSession().removeAttribute("usuario");
				request.getSession().removeAttribute("carrito-lista");
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
