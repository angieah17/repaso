package ejercicio.persona;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Utilidades {

	public static List<Persona> generarListaPersonas (int n){
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		for (int i = 0; i < n; i++) {
			
			try {
				listaPersonas.add(new Persona());
			} catch (ApellidosIgualesException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return listaPersonas;
	}
	
	public static List<Persona> filtradoAMedida(List<Persona> lista, Predicate<Persona> filtro){
		
		List<Persona> listaFiltrada = 
		
		lista.stream()
		.filter(filtro)
		.toList();
		
		
		return listaFiltrada;
		
		
	}
	
	public static void reportEntreAnios (List<Persona> lista, int anioDesde, int anioHasta, boolean ordenDirecto) {
		
		
		
		long cantidadTotalPersonas = 
		lista.stream()
		.filter(p -> p.getAnioNacimiento() <= anioHasta && p.getAnioNacimiento() >= anioDesde)
		.sorted(ordenDirecto ? Comparator.naturalOrder() : Comparator.reverseOrder())
		.peek(System.out::println)
		.count();
		
		
		
		System.out.printf("Cantidad total de Personas nacidas entre %d y %d es: %d.%n", anioDesde, anioHasta, cantidadTotalPersonas);
		
	}
	
	public static void cuentaLetras(List<Persona> lista) {
		
		int cantidadLetrasNombre =
		
		lista.stream()
		.mapToInt(p -> p.getNombre().length())
		.sum();
		
		int cantidadLetrasApellido1 =
				
				lista.stream()
				.mapToInt(p -> p.getApellido1().length())
				.sum();
		
		int cantidadLetrasApellido2 =
				
				lista.stream()
				.mapToInt(p -> p.getApellido2().length())
				.sum();
		
		System.out.printf("Cantidad de Letras:%n-Nombre: %d%n-Apellido1: %d%n-Apellido2: %d%n",cantidadLetrasNombre, cantidadLetrasApellido1, cantidadLetrasApellido2);
		
		
	}
	
	public static List<Persona> personasUnicas(List<Persona> lista){
		
		List<Persona> personasUnicas =
		
		
		lista.stream()
		.distinct()
		.toList();
		
		
		return personasUnicas;
	}
	
	
	public static Optional<Persona> personasIgual (List<Persona> lista, Persona persona){
		
		Optional<Persona> personaIgual =
		
		lista.stream()
		.filter(p -> p.equals(persona))
		.findFirst();
		
		return personaIgual;
		
	}
	
	
	public static void main(String[] args) {

		System.out.println("----------- PROBANDO GENERAR LISTA -----------");
		List<Persona> lista = Utilidades.generarListaPersonas(5);
		
		lista.forEach(System.out::println);
		
		System.out.println("\n----------- PROBANDO LISTA FILTRADA  -----------");
		
		List<Persona> listaFiltrada =
		Utilidades.filtradoAMedida(lista, p -> p.getAnioNacimiento() > 2_000);
		
		listaFiltrada.forEach(System.out::println);
		
		System.out.println("\n----------- PROBANDO REPORT ENTRE ANIOS  -----------");
		Utilidades.reportEntreAnios(lista, 1_910, 2_024, false);
		Utilidades.reportEntreAnios(lista, 1_980, 2_010, true);
		
		System.out.println("\n----------- PROBANDO CUENTA LETRAS  -----------");
		
		Utilidades.cuentaLetras(lista);
		
		System.out.println("\n----------- PROBANDO PERSONAS ÚNICAS  -----------");
		System.out.println("Lista Completa");
		lista.add(lista.get(0));
		lista.forEach(System.out::println);
		
		System.out.println("Lista Filtrada Personas Unicas");
		List<Persona> listaPersonasUnicas = Utilidades.personasUnicas(lista);
		
		listaPersonasUnicas.forEach(System.out::println);
		
		
		System.out.println("\n----------- PROBANDO PERSONA IGUAL  -----------");
		
		System.out.println("Persona NO igual");
		
		try {
		System.out.println(Utilidades.personasIgual(lista, new Persona()));	
		} catch (ApellidosIgualesException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Persona IGUAL");
		
		lista.add(lista.get(0));
		
		System.out.println(Utilidades.personasIgual(lista, lista.get(0)));	
			
			
		
		//  Utilidades.personasIgual(lista, );
		
		
		/*Persona p = new Persona();
			Persona p2 = new Persona();
			
			System.out.println(p);
			System.out.println(p2);
			
		List<Persona> lista = new ArrayList<Persona>();
		
		lista.add(p2);
		lista.add(p);
		
		lista.stream().sorted().forEach(System.out::println);;*/
		
	}

}
