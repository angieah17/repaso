package ejercicio.producto;

public class Producto {
	
	//1. Propiedades
	private int id;
	private String nombre;
	private int cantidad;
	
	
	//2. Constructor
	public Producto(int id, String nombre, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public int getId() {
		return id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
