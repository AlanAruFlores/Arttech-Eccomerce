package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import classes.*;


import classesDao.*;
import datos.*;



/**
 * Servlet implementation class ModificarUsuarioServlet
 */
public class ModificarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarUsuarioServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	

			if(request.getSession().getAttribute("usuario") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				String mail = request.getParameter("email");
				Usuario usuario = new Usuario(id,nombre,mail);
				UsuarioDAO dao = new UsuarioDAO(Conexion.getConnection());
				dao.modificarUsuario(usuario);
				response.sendRedirect("Administracion.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
