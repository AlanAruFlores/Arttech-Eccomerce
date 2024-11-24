package classesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.*;
import java.util.*;
public class PedidoDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String query;
	
	public PedidoDAO(Connection conn) throws ClassNotFoundException, SQLException {
		this.conn = conn;
	}
	
	public boolean insertarPedido(Pedido pedido) {
		boolean value = false;
		try {
			query = "INSERT INTO pedidos (producto_id,usuario_id,cantidad,fecha) VALUES(?,?,?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1,pedido.getIdProducto());
			stmt.setInt(2,pedido.getIdUsuario());
			stmt.setInt(3, pedido.getCantidad());
			stmt.setString(4, pedido.getFecha());
			int filaAfectada = stmt.executeUpdate();
			if(filaAfectada > 0) {
				value = true;
			}
		}catch(SQLException  ex) {
			ex.printStackTrace();
		}
		return value;
	}
	
	public List<Pedido> listaPedidos(int id){
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		try {
			
			query="SELECT * FROM pedidos WHERE usuario_id=? order by pedidos.pedido_id desc";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProductoDAO dao = new ProductoDAO(this.conn);
				Producto prod = dao.getProducto(rs.getInt("producto_id"));
				
				Pedido ped = new Pedido();
				ped.setIdPedido(rs.getInt("pedido_id"));
				ped.setId(rs.getInt("producto_id"));
				ped.setNombre(prod.getNombre());
				ped.setCategoria(prod.getCategoria());
				ped.setPrecio(prod.getPrecio()*rs.getInt("cantidad"));
				ped.setCantidad(rs.getInt("cantidad"));
				ped.setFecha(rs.getString("fecha"));
				listaPedidos.add(ped);
				
			}
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return listaPedidos;
	}
	
	public void eliminarPedido(int id) {
		
		boolean value = false;
		try {
			query ="DELETE FROM pedidos WHERE pedido_id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			int sqlEjecucion = stmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
