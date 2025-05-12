package ejercicio1.examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Persona {
	
	Random random = new Random();
	
	//1. Propiedades
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int anioDeNacimiento;
	private int id;
	private static int nextID;
	
		
	private int generarAnioAleatorio() {
			
		return random.nextInt(1910, 2025);
		
	}
	
	
	//2. Constructor
	public Persona() {
		
		
		String[] nombres = {
			    "María", "Juan", "Ana", "Carlos", "Laura",
			    "Pedro", "Sofía", "Miguel", "Isabel", "David"
			};
		
		String[] apellidos = {
			    "García", "Rodríguez", "González", "Fernández", "López",
			    "Martínez", "Sánchez", "Pérez", "Gómez", "Martín"
			};
		
		nombre = nombres[random.nextInt(nombres.length)];		
		apellido1 = apellidos[random.nextInt(apellidos.length)];
		apellido2 = apellidos[random.nextInt(apellidos.length)];
		anioDeNacimiento = generarAnioAleatorio();
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Persona [random=" + random + ", nombre="   + nombre + ", apellido1=" + apellido1 + ", apelligo2="
				+ apellido2 + ", anioDeNacimiento=" + anioDeNacimiento + ", id=" + id + "]";
	}


	public static void main(String[] args) {
		Persona p = new Persona();
		
		System.out.println(p);
		
	}
	
	
}
