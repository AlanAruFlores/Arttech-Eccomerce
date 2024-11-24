package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import datos.Conexion;
import datos.Conexion;
import classes.*;
import classesDao.*;
/**
 * Servlet implementation class EliminarUsuario
 */
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if(usuario != null) {
				UsuarioDAO dao = new UsuarioDAO(Conexion.getConnection());
				dao.eliminarUsuario(id);
				response.sendRedirect("PanelUsuarios.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
