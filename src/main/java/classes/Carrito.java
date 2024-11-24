package classes;

public class Carrito extends Producto{

	private int cantidad;

	public Carrito(int id, String nombre, String categoria,double precio, int cantidad) {
		super(id,nombre,categoria,precio);
		this.cantidad = cantidad;
		
	}
	public Carrito(int id , int cantidad) {
		super(id);
		this.cantidad = cantidad;
	}
	
	
	public void setCantidad(int cantidad) {
		this.cantidad+=cantidad;
	}
	public int getCantidad() {
		return this.cantidad;
	}
}

