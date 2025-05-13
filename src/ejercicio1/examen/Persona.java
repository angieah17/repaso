package ejercicio1.examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Persona implements Comparable<Persona> {
	
	
	
	//1. Propiedades
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int anioDeNacimiento;
	private int id;
	private static int nextID = 1; //Debe ser estático, compartido por toda la clase para que inicie así 
	private Random random = new Random();	
	
	//2. Constructor
	public Persona() throws ApellidosIgualesException {
		
		
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
		
		if(apellido1.equalsIgnoreCase(apellido2)) {
			throw new ApellidosIgualesException("Apellidos iguales. No es válido.");
		}		
		
		anioDeNacimiento = random.nextInt(1910, 2025);
		id = nextID++; //Aquí se va incrementando en cada instancia
	}
	
	//3. Getters
	

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public int getAnioDeNacimiento() {
		return anioDeNacimiento;
	}

	public int getId() {
		return id;
	}

	public static int getNextID() {
		return nextID;
	}
	
	//4. ToString
	
	@Override
	public String toString() {
		return String.format("%s %s, %s%n", apellido1, apellido2, nombre).toUpperCase();
	}

	
	//5. CompareTo
	
	@Override
	public int compareTo(Persona o) {
		
		int compApellido1 = apellido1.compareToIgnoreCase(o.apellido1);
		
		if(compApellido1 != 0) { 
			return compApellido1; // Si tienen distintos apellidos1, entonces aplicame el criterio de comparación de apellido1
		} 
		
		//Si tienen el mismo apellido1 entonces va a revisar otros criterios

		int compApellido2 = apellido2.compareToIgnoreCase(o.apellido2);
		
		if (compApellido2 != 0) {
			return compApellido2;
		} 
		
		return nombre.compareToIgnoreCase(o.nombre);
		
		
	}

	
	
	//6. Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(anioDeNacimiento, apellido1, apellido2, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return anioDeNacimiento == other.anioDeNacimiento && Objects.equals(apellido1, other.apellido1)
				&& Objects.equals(apellido2, other.apellido2) && Objects.equals(nombre, other.nombre);
	}

	


	/*public static void main(String[] args) {
		
		//Persona p = new Persona();
		//Persona p2 = new Persona();
		
		
		System.out.println(p);
		System.out.println(p2);
		
		System.out.println("antes");
		List<Persona> personas = new ArrayList<>();
		
		personas.add(p2);
		personas.add(p);
		
		 
		
		personas.stream().sorted().forEach(System.out::println);
		
		
	}
*/
	
	
	
	
	
	
}
