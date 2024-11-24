package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.*;
import classesDao.*;
import datos.Conexion;

import java.sql.*;

/**
 * Servlet implementation class CrearUsuario
 */
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				String nombre = request.getParameter("nombre");
				String mail = request.getParameter("mail");
				String contrasenia = request.getParameter("contrasenia");
				int telefono = Integer.parseInt(request.getParameter("telefono"));
				String fecha = request.getParameter("fecha");
				Usuario usuario = new Usuario(nombre,mail,contrasenia,fecha,telefono);
				UsuarioDAO dao = new UsuarioDAO(Conexion.getConnection());
				dao.insertarUsuario(usuario);	
				response.sendRedirect("index.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
