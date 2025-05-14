package ejercicio.empleado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Empleado {

	// 1. Propiedades
	private int id;
	private static int nextID;
	private String nombre;
	private String departamento;
	private double salario;

	// 2. Constructor
	public Empleado(String nombre, String departamento, double salario) {
		id = nextID++;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ "]";
	}

	public static void main(String[] args) {

		List<Empleado> listaEmpleados = new ArrayList<Empleado>();

		listaEmpleados.add(new Empleado("Pedro", "Ventas", 1.000));
		listaEmpleados.add(new Empleado("Jose", "Ventas", 2.000));
		listaEmpleados.add(new Empleado("Angie", "Ventas", 3.000));
		
		/*listaEmpleados.stream()
			.filter(e -> e.departamento.equalsIgnoreCase("VENTAS"))
			.map(e -> e.nombre.toUpperCase())
			.sorted(Comparator.comparingDouble(Empleado::salario).reversed())
			.forEach(System.out::println);
		*/
		
		
		
		
		listaEmpleados.stream()
			.filter(p -> p.departamento.equalsIgnoreCase("Ventas"))
			.sorted((p, p2) -> Double.compare(p2.salario, p.salario))
			.map(p -> p.nombre.toUpperCase())
			.toList().forEach(System.out::println);;
		
			/*En este caso el Comparator se necesita tener un getter del salario 
			 * para poder acceder a salario.
			 * 
			listaEmpleados.stream()
			.filter(p -> p.departamento.equalsIgnoreCase("Ventas"))
			.sorted(Comparator.comparingDouble(p -> p.salario).reversed())
			.map(p -> p.nombre.toUpperCase())
			.toList().forEach(System.out::println);;
			
		*/
		

	}

}
