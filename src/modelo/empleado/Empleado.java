package modelo.empleado;

import java.util.Objects;
import java.util.Random;

public class Empleado implements Comparable<Empleado> {
	
	private String nombre;
	private String puesto;
	private int anioIngreso;
	private byte nivelAcceso;
	private int id;
	private static int nextID = 1_000;
	private Departamento departamento;
	private Random random = new Random();
	
	
	public Empleado() throws NivelAccesoInvalidoException {
		
		String [] nombres = {"Angie", "Angie", "Maria","Pablo"};
		String [] puestos = {"Gerente", "Vendedor", "Desarrollador", "Director Marketing", "Encargado de HR", "Becario"};
		Departamento [] arrayDepartamentos = Departamento.values();
		
		nombre = nombres[random.nextInt(nombres.length)];
		puesto = puestos[random.nextInt(puestos.length)];
		anioIngreso = random.nextInt(1_990, 2_025);
		id = nextID++;
		departamento = arrayDepartamentos[random.nextInt(arrayDepartamentos.length)];
		nivelAcceso = (byte) random.nextInt(1, 11);
		
		if("Becario".equals(puesto) && nivelAcceso > 8) {
			
			throw new NivelAccesoInvalidoException("El Nivel de Acceso es mayor a 8 para el puesto de Becario.");
			
		}
		
		
	}

	
	




	@Override
	public int compareTo(Empleado o) {
		
		int compDepartamento = departamento.compareTo(o.departamento);
		
		int compAnioIngreso = anioIngreso - o.anioIngreso;
		
		if(compDepartamento != 0) {
			return compDepartamento;
		}
		
		if(compAnioIngreso != 0) {
			return compAnioIngreso;
		}
					
		
		return nombre.compareToIgnoreCase(o.nombre);
	}
	
	
	

	@Override
	public String toString() {
		return String.format("%d - %s (%s, %d)%n", id, nombre.toUpperCase(), departamento, anioIngreso);
	}
	


	
	// Getters
	public String getNombre() {
		return nombre;
	}



	public String getPuesto() {
		return puesto;
	}



	public int getAnioIngreso() {
		return anioIngreso;
	}



	public byte getNivelAcceso() {
		return nivelAcceso;
	}



	public int getId() {
		return id;
	}



	public static int getNextID() {
		return nextID;
	}



	public Departamento getDepartamento() {
		return departamento;
	}







	@Override
	public int hashCode() {
		return Objects.hash(anioIngreso, departamento, nombre);
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return anioIngreso == other.anioIngreso && departamento == other.departamento
				&& Objects.equals(nombre, other.nombre);
	}



	
	
	/*
	public static void main(String[] args) {
		
		Empleado e = new Empleado();
		Empleado e2 = new Empleado();
		
		System.out.println(e);
		System.out.println(e2);
		
	}

*/


	
	
	
}
