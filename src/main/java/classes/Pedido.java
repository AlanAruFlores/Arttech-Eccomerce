package classes;

public class Pedido extends Producto{
	private int idPedido;
	private int idUsuario;
	private int idProducto;
	private int cantidad;
	private String fecha;
	
	
	public Pedido (int idPedido,int idProducto, int idUsuario, int cantidad, String fecha){
		super();
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	public Pedido (int idProducto, int idUsuario, int cantidad, String fecha){
		super();
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Pedido(int idUsuario, int cantidad, String fecha) {
		super();
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	public Pedido() {
		
	}
	
	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
