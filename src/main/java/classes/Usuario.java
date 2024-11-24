package classes;

public class Usuario {
	private int id;
	private String nombre;
	private String contraseña;
	private String email;
	private String fecha;
	private int telefono;
	
	public Usuario(String nombre, String email, String contraseña, String fecha, int telefono) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.email  =email;
		this.fecha = fecha;
		this.telefono = telefono;
	}
	public Usuario(String nombre, String contraseña, String email) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.email = email;
	}
	public Usuario(int id, String nombre , String email) {
		this(nombre,"", email);
		this.id = id;
	}
	public Usuario(String email, String contraseña) {
		this("", contraseña, email);
	}
	
	public Usuario(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public String getNombre() {
		return this.nombre;
		
	}
	public String getEmail() {
		return this.email;
	}
	public String getContraseña() {
		return this.contraseña;
	}
	public String getFecha() {
		return this.fecha;
	}
	public int getTelefono() {
		return this.telefono;
	}
	
}
