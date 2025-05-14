package ejercicio.estudiante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Estudiante {
	
	//1. Propiedades
	private String nombre; 
	private String apellido;
	private int edad; 
	private Double promedio;
	
	
	
	
	//2. Constructor 


	public Estudiante(String nombre, String apellido, int edad, Double promedio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.promedio = promedio;
	}
	
	//3. Getter
	//Necesito el getter para acceder en el Comparator al apellido
	
	public String getApellido() {
		return apellido;
	}
	
	//MAIN
	public static void main(String[] args) {
		
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		
        estudiantes.add(new Estudiante("Juan", "Gómez", 20, 8.5));
        estudiantes.add(new Estudiante("María", "López", 21, 7.2));
        estudiantes.add(new Estudiante("Carlos", "Martínez", 22, 9.1));
        estudiantes.add(new Estudiante("Ana", "Rodríguez", 19, null)); // Promedio null
        estudiantes.add(new Estudiante("Pedro", "Sánchez", 20, 8.8));
		
       List<String> lista =
        
        estudiantes.stream()
        .filter(es -> {
        	
        	try {
				return es.promedio > 8.0; //Se incluye el return porque es la expresión de la lambda
			} catch (NullPointerException e) {
				System.out.println("Error el promedio es null.");
				return false; //Se incluye el false porque filter tira de un Predicate que retorna un boolean
			}
        	      	
        })
        .sorted( (e, e2) -> e.apellido.compareTo(e2.apellido))
        .map( e -> e.nombre + " " + e.apellido + "-" + e.promedio)
        .toList();
        
          lista.forEach(System.out::println);      
        
        
        /*
       List<String> lista =
        estudiantes.stream()
        .filter( e -> {
        	
        	try {
				return e.promedio > 8.0;
			} catch (NullPointerException e2) {
				System.out.println("Error promedio null");
				return false;
			}
        	
        })		
        .sorted(Comparator.comparing(Estudiante::getApellido))
        .map(e -> e.nombre + " " + e.apellido + "-" + e.promedio) //El map() se puede ir concantenando pues es un String
        .toList(); 
        
        
       lista.forEach(System.out::println);*/
        
        
        
        
        
	}
	
	
}
