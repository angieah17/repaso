package ejercicio.persona;

import java.util.Objects;
import java.util.Random;

public class Persona implements Comparable<Persona> {
	
	//1. Propiedades
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int anioNacimiento;
	private int id;
	private static int nextID = 1;
	private Random random = new Random();
	
	//2. Constructor
	
	public Persona() throws ApellidosIgualesException {
		
		String [] nombres = {"María", "Luis", "María", "Luis", "Angie", "Jose"};
		
		String [] apellidos = {"García", "Perez", "Gonzales", "Garcia", "Perez", "Amado"};
		
		nombre = nombres[random.nextInt(nombres.length)];
		apellido1 = apellidos[random.nextInt(apellidos.length)];
		apellido2 = apellidos[random.nextInt(apellidos.length)];
		
		if (apellido1.equals(apellido2)) {
			throw new ApellidosIgualesException("NO pueden existir personas con apellidos iguales en esta aplicación.");
		}
		
		anioNacimiento = random.nextInt(1910, 2024);
		id = nextID++;
		
		
	}
	
	//3. Orden por defecto
	
	@Override
	public int compareTo(Persona o) {
		
		int compApellido1 = apellido1.compareTo(o.apellido1);
		
		int compApellido2 = apellido2.compareTo(o.apellido2);
		
		if(compApellido1 != 0) {
			return compApellido1;
		} else if (compApellido2 != 0) {
			return compApellido2;
		}

		return nombre.compareTo(o.nombre);
	}
	
	
	
	//4. ToString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", anioNacimiento=" + anioNacimiento + ", id=" + id + "]";
	}


	//5. Getters
	
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public int getId() {
		return id;
	}

	public static int getNextID() {
		return nextID;
	}

	
	
	//6. Equals y HashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(anioNacimiento, apellido1, apellido2, nombre);
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
		return anioNacimiento == other.anioNacimiento && Objects.equals(apellido1, other.apellido1)
				&& Objects.equals(apellido2, other.apellido2) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
