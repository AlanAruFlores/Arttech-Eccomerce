package classesDao;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import classes.*;
import datos.Conexion;
public class UsuarioDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String query;
	
	public UsuarioDAO(Connection conn) throws ClassNotFoundException, SQLException{
		this.conn = conn;
	}
	public Usuario loginUser(Usuario usuario) {
		Usuario usuarioSelected = null;
		try {
		    query ="SELECT id,nombre,email FROM usuario WHERE email = ? and contrasenia = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getContraseña());
			rs = stmt.executeQuery();
			if(rs.next()) {
				usuarioSelected  = new Usuario(rs.getInt("id"), rs.getString("nombre"),rs.getString("email"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return usuarioSelected;
	}
	public List<Usuario> getUsuarios(Usuario usuario){
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			query="SELECT * FROM usuario WHERE email != ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, usuario.getEmail());
			rs= stmt.executeQuery();
			while(rs.next()) {
				listaUsuario.add(new Usuario(rs.getInt("id"), rs.getString("nombre"),rs.getString("email")));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return listaUsuario;
	}
	public void eliminarUsuario(int id) {
		try {
			query="DELETE FROM usuario WHERE id = ?";
			stmt= conn.prepareStatement(query);
			stmt.setInt(1, id);
			int filaAffectada = stmt.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void modificarUsuario(Usuario usuario) {
		try {
			query = "UPDATE usuario SET nombre = ? , email = ? WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1,usuario.getNombre());
			stmt.setString(2, usuario.getEmail());
			stmt.setInt(3, usuario.getId());
			int filaAfectada = stmt.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertarUsuario(Usuario usuario) {
		try {
			query="INSERT INTO usuario (nombre,email,contrasenia,telefono,fecha_nacimiento) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getContraseña());
			stmt.setInt(4, usuario.getTelefono());
			stmt.setString(5, usuario.getFecha());
			int ejecutarQuery = stmt.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
