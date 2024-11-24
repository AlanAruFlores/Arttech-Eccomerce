package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classes.Usuario;
import classesDao.UsuarioDAO;
import datos.Conexion;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
			Usuario obj = new Usuario(request.getParameter("mail"), request.getParameter("contrasenia"));
			UsuarioDAO dao = new UsuarioDAO(Conexion.getConnection());
			Usuario objSeleccionado = dao.loginUser(obj);
			if(objSeleccionado != null) {
				request.getSession().setAttribute("usuario", objSeleccionado);
				if(objSeleccionado.getEmail().equals("admin@gmail.com")) {
					response.sendRedirect("Administracion.jsp");
				}else {
					response.sendRedirect("index.jsp");					
				}
			}
			else {
				response.sendRedirect("login.jsp");

			}
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
