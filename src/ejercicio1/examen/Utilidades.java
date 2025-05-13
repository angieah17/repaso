package ejercicio1.examen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Utilidades {

	public static List<Persona> generaListaPersonas(int n){
		
		List<Persona> personas = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			try {
				personas.add(new Persona());
			} catch (ApellidosIgualesException e) {
				System.out.println(e.getMessage()); 
			}
		}
				
		
		return personas;
		
		
	}
	
	public static List<Persona> filtradoAMedida(List<Persona> lista, Predicate<Persona> filtro){
		
		List<Persona> listaFiltrada = new ArrayList<Persona>();
		
		for (Persona persona : lista) {
			if(filtro.test(persona)) {
				listaFiltrada.add(persona);
			}
		}
		
		
		return listaFiltrada;
	}
	
	public static void reportEntreAnios(List<Persona> lista, int anioDesde, int anioHasta, boolean ordenDirecto) {
				
		
		/*
		if(ordenDirecto == true) {
						
			lista.stream()
			.filter(p -> p.getAnioDeNacimiento() <= anioHasta && p.getAnioDeNacimiento() >= anioDesde)
			.sorted()
			.forEach(System.out::println);;
		} else {
			lista.stream()
			.filter(p -> p.getAnioDeNacimiento() <= anioHasta && p.getAnioDeNacimiento() >= anioDesde)
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);;
		}*/
		
		//Forma mejorada
		
		 long count = lista.stream()
		            .filter(p -> p.getAnioDeNacimiento() <= anioHasta && p.getAnioDeNacimiento() >= anioDesde)
		            .sorted(ordenDirecto ? Comparator.naturalOrder() : Comparator.reverseOrder())
		            .peek(System.out::println)
		            .count();
		    
		    System.out.println("Total de personas listadas: " + count);
		
		
	}
	
	public static void cuentaLetras(List<Persona> lista) {
		
		int conteoLetrasNombre = lista.stream()
										.mapToInt(p -> p.getNombre().length())
										.sum();
		int conteoLetrasApellido1 = lista.stream().mapToInt(p -> p.getApellido1().length()).sum();
		
		int conteoLetrasApellido2 = lista.stream().mapToInt(p -> p.getApellido2().length()).sum();
		
		
		System.out.printf("Cantidad de Letras:%n-Nombre: %d%n-Apellido1: %d%n-Apellido2: %d%n", conteoLetrasNombre, conteoLetrasApellido1, conteoLetrasApellido2);
		
	}
	
	public static List<Persona> personasUnicas(List<Persona> lista){
				
		return lista.stream().distinct().toList();
		
		
	}
	
	public static Optional<Persona> personasIgual(List<Persona> lista, Persona persona){
		
		Optional<Persona> personaIgual = lista.stream().filter(p -> p.equals(persona)).findFirst();
		
		return personaIgual;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("-------- PROBANDO GENERAR LISTA --------");
		
		List<Persona> listaPersonas = Utilidades.generaListaPersonas(10);
		listaPersonas.forEach(System.out::println);
		
		System.out.println();
		System.out.println("-------- PROBANDO FILTRO PERSONAS NACIDAS DESPUÉS DE 2000 --------");
		
		List<Persona> filtradas = Utilidades.filtradoAMedida(
		        listaPersonas, 
		        p -> p.getAnioDeNacimiento() > 2000
		    );
		
		filtradas.forEach(System.out::println);
		
		System.out.println("\n-------- REPORTE ENTRE AÑOS 1950-2000 (ORDEN NATURAL) --------");
	    Utilidades.reportEntreAnios(listaPersonas, 1950, 2000, true);
	    
	    System.out.println("\n-------- REPORTE ENTRE AÑOS 1950-2000 (ORDEN INVERSO) --------");
	    Utilidades.reportEntreAnios(listaPersonas, 1950, 2000, false);
	    
	    System.out.println("\n-------- CONTEO DE LETRAS EN NOMBRES Y APELLIDOS --------");
	    Utilidades.cuentaLetras(listaPersonas);
		
		
		System.out.println("-------- PROBANDO REPORT CONTEO LETRAS --------");
		
		Utilidades.cuentaLetras(listaPersonas);
		System.out.println();
		
		 System.out.println("\n-------- PERSONAS ÚNICAS (ELIMINANDO DUPLICADOS) --------");
		    // Añadimos un duplicado para probar
		    if (!listaPersonas.isEmpty()) {
		        listaPersonas.add(listaPersonas.get(0));
		    }
		    List<Persona> unicas = Utilidades.personasUnicas(listaPersonas);
		    unicas.forEach(System.out::println);
		
		    System.out.println("\n-------- BUSCANDO PERSONA IGUAL (EXISTENTE) --------");
		    if (!listaPersonas.isEmpty()) {
		        Persona personaBuscada = listaPersonas.get(0);
		        Optional<Persona> encontrada = Utilidades.personasIgual(listaPersonas, personaBuscada);
		        encontrada.ifPresentOrElse(
		            p -> System.out.println("Encontrada: " + p),
		            () -> System.out.println("No encontrada")
		        );
		    }
		    
		    System.out.println("\n-------- BUSCANDO PERSONA INEXISTENTE --------");
		    try {
		        Persona personaNueva = new Persona();
		        Optional<Persona> encontrada = Utilidades.personasIgual(listaPersonas, personaNueva);
		        encontrada.ifPresentOrElse(
		            p -> System.out.println("Encontrada: " + p),
		            () -> System.out.println("No encontrada (como se esperaba)")
		        );
		    } catch (ApellidosIgualesException e) {
		        System.out.println("Error creando persona de prueba: " + e.getMessage());
		    }
		
	}

	
	
	
}
