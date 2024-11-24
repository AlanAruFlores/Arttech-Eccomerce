package classes;

public class Producto {
	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	private String imagen;
	private String descripcion;
	
	public Producto(int id, String nombre, String categoria, double precio,String imagen,String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}
	public Producto(int id, String nombre, String categoria, double precio, String imagen ) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.imagen = imagen;
	}
	public Producto(int id, String nombre, String categoria, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}
	public Producto(int id, double precio, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public Producto(int id, double precio, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Producto(int id) {
		this.id = id;
	}
	public Producto() {
		
	}
	public int getId() {
		return this.id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getCategoria() {
		return this.categoria;
	}
	public double getPrecio() {
		return this.precio;
	}
	public String getImagen() {
		return this.imagen;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String nuevaDescripcion) {
		this.descripcion = nuevaDescripcion;
	}
}
