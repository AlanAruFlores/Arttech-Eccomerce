package classesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.*;
import datos.*;
import java.util.*;
public class ProductoDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String query;
	
	public ProductoDAO(Connection conn) throws ClassNotFoundException, SQLException {
		this.conn = conn;
	}
	
	public Producto getProducto(int id) {
		Producto producto = null;
		try {
			query = "SELECT * FROM producto WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next())
				producto = new Producto(rs.getInt("id"),rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"));
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return producto;
	}
	public List<Producto> getListaProductos(){
		List<Producto> lista  = new ArrayList<Producto>();
		
		try {
			query = "SELECT * FROM producto";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next())
				lista.add(new Producto(rs.getInt("id"),rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getString("imagen")));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lista;
		
	}
	public List<Producto> getListaProductos2(){
		List<Producto> lista  = new ArrayList<Producto>();
		
		try {
			query = "SELECT * FROM producto";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next())
				lista.add(new Producto(rs.getInt("id"),rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getString("imagen"),rs.getString("descripcion")));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lista;
		
	}
	
	public List<Carrito> getListaCarrito(List<Carrito> productosCarrito){
		List<Carrito> productos = new ArrayList<Carrito>();
		try {
			if(productosCarrito.size() > 0) {
				for(Carrito carr : productosCarrito) {
					query = "SELECT  * FROM producto WHERE id = ?";
					stmt = conn.prepareStatement(query);
					stmt.setInt(1,carr.getId());
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						Carrito row = new Carrito(rs.getInt("id"), rs.getString("nombre"),rs.getString("categoria"),
						rs.getDouble("precio") * carr.getCantidad(),carr.getCantidad());
						productos.add(row);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return productos;
	}
	
	public double getTotalImporte(List<Carrito> listaCarrito) {
		double importeTotal = 0;
		try {
			for(Carrito carr : listaCarrito) {
				query = "SELECT precio FROM producto WHERE id=?";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, carr.getId());
				rs = stmt.executeQuery();
				while(rs.next())
					importeTotal += rs.getDouble("precio") * carr.getCantidad();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return importeTotal;
	}
	
	public void eliminarProducto(int id) {
		try {
			query = "DELETE FROM producto WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			int filaAfectada = stmt.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void modificarProducto(Producto producto) {
		try {
			query ="UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1,producto.getNombre());
			stmt.setDouble(2, producto.getPrecio());
			stmt.setInt(3, producto.getId());
			int filaAfectada = stmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Producto> obtenerTipoProducto(String tipo){
		List<Producto> lista  = new ArrayList<Producto>();
		try {
			query = "SELECT * FROM producto WHERE categoria = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1,tipo);
			rs = stmt.executeQuery();
			
			while(rs.next())
				lista.add(new Producto(rs.getInt("id"),rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getString("imagen"),rs.getString("descripcion")));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}
}
