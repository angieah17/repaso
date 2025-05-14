package ejercicio.coche;

import java.util.ArrayList;
import java.util.List;

public class Coche {
	
	//1. Propiedades
	private int id;
	private String modelo;
	private Double precio;
	private EstadoCoche estado;
	
		
	//2. Constructor
	
	public Coche(int id, String modelo, Double precio, EstadoCoche estado) {
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.estado = estado;
	}
	
	public static void main(String[] args) {
		List<Coche> listaCoches = new ArrayList<Coche>();
	
		listaCoches.add(new Coche(1, "Toyota Corolla", 25000.0, EstadoCoche.NUEVO));
        listaCoches.add(new Coche(2, "Honda Civic", 22000.0, EstadoCoche.NUEVO));
        listaCoches.add(new Coche(3, "Ford Mustang", 45000.0, EstadoCoche.USADO));
        listaCoches.add(new Coche(4, "Volkswagen Golf", 18000.0, EstadoCoche.EN_REPARACION));
        listaCoches.add(new Coche(5, "BMW Serie 3", 38000.0, EstadoCoche.USADO));
        listaCoches.add(new Coche(6, "Audi A4", 42000.0, EstadoCoche.NUEVO));
        listaCoches.add(new Coche(7, "Mercedes Clase C", 47000.0, EstadoCoche.USADO));
        listaCoches.add(new Coche(8, "Tesla Model 3", 55000.0, EstadoCoche.NUEVO));
        listaCoches.add(new Coche(9, "Nissan Qashqai", 32000.0, EstadoCoche.EN_REPARACION));
        listaCoches.add(new Coche(10, "Hyundai Tucson", 29000.0, EstadoCoche.USADO));
        
        
		listaCoches.stream()
		.filter(c -> c.id == 5)
		.forEach(System.out::println);
		
	
	}
	
	
	
	
}
