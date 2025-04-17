package stream.counter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

public class Test {

	private static Random random = new Random();

	public static void main(String[] args) {

		List<Ciudad> ciudades = new ArrayList<>();

		String[] nombresCiudades = { "Ciudad 1", "Ciudad 2", "Ciudad 3", "Ciudad 4", "Ciudad 5", "Ciudad 6", "Ciudad 7",
				"Ciudad 8", "Ciudad 9", "Ciudad 10" };

		for (String nombreCiudad : nombresCiudades) {

			Ciudad ciudad = new Ciudad(nombreCiudad);

			for (int i = 0; i < random.nextInt(10_000, 12_001); i++) { // Para cada ciudad se va a crear entre 0 y
																		// 10_000 o 0 y 12_000 contadores en cada ciudad
																		// de manera aleatoria
				ciudad.addCounter(new Counter(50_000)); // Es el valor máximo de todos los contadores que se van a ir
														// creando.
			}

			// Se pone solo new Counter porque no se necesita guardar en una variable cada
			// nuevo Counter que se va creando,
			// pues estos se van guardando directamente en la lista de counters.

			ciudades.add(ciudad);

		}

		for (Ciudad ciudad : ciudades) {

			for (Counter counter : ciudad.getContadores()) {

				for (int i = 0; i < 25; i++) {
					counter.increment(random.nextInt(250, 1_001));

				}

			}

		}

		// Minimo para una ciudad

		Ciudad miCiudad = ciudades.get(0);

		System.out.println(miCiudad.getContadores().stream().map(c -> c.getValue()).sorted().findFirst());

		// Máximo consumo de individual entre todos los contadores

		OptionalInt maximo =

				ciudades.stream().flatMap(lc -> lc.getContadores().stream()).mapToInt(c -> c.getValue()).max();

		System.out.println(maximo);

		// Ciudad con el mayor consumo total

		ciudades.stream()
				.max(Comparator.comparingInt(c -> c.getContadores().stream().mapToInt(con -> con.getValue()).sum()));

		//Ciudad mayor número de contadores a los que se puede hacer reset
		ciudades.stream()
		.max(Comparator.comparingInt(c -> (int) c.getContadores().stream().filter( ci -> ci.reset()).count()))
		;
		
		
		
		//Cual es el consumo total de todas la ciudades para aquellos contadores que están entre 0 y 1_000
		
		ciudades.stream()
		.flatMap(lc -> lc.getContadores().stream())
				.mapToInt(c -> c.getValue())
				.filter(v -> v > 0 && v <= 1_000)
				.sum();
		
	}

}
