package streams.cuentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Test {
	
public static String [] devuelvePalabras (String cuento) {
		
		String cuentoSinComasPuntos = cuento.replaceAll("[,.]", "");
		String cuentoSinSaltos = cuentoSinComasPuntos.replaceAll("[\\s+]", " ");
		
		//System.out.println(cuentoSinComasPuntos);
		//System.out.println(cuentoSinSaltos);
		
		String [] caracteresCuentos = cuentoSinSaltos.trim().split(" ");
		
		return caracteresCuentos;
			
				
	}
	 
	public static void arrayPalabras (String cuento) {
		
		System.out.println("Array de palabras");
		System.out.println("=================");
		
		int contador = 0;
		
		for (String palabra : devuelvePalabras(cuento)) {
			System.out.printf("[%s]",palabra);
			contador++;
		}
		System.out.println();
		System.out.printf("Lista original tiene %d palabras.%n", contador);
		
	}

	public static void arrayListPalabras (String [] cuento) {
		
		ArrayList<String> arrayListDeCuento = new ArrayList<>();
		
		for (String c : cuento) {
			arrayListDeCuento.add(c);
		}
		
		System.out.println("ArrayList de palabras");
		System.out.println("=====================");
		
		for (String palabra : arrayListDeCuento) {
				System.out.printf("[%s]",palabra);	
		}
		
		
		
		System.out.println();
		System.out.printf("Lista en ArrayList tiene %d palabras.%n", arrayListDeCuento.size());
		
		
		
	}
	
	public static void hashSetPalabras (String [] cuento) {
		
		HashSet<String> hashSetDeCuento = new HashSet<>();
		
		for (String c : cuento) {
			hashSetDeCuento.add(c);
		}
		
		System.out.println("HashSet de palabras");
		System.out.println("===================");
		
		for (String palabra : hashSetDeCuento) {
				System.out.printf("[%s]",palabra);	
		}
	
		
		System.out.println();
		System.out.printf("Lista en HashSet tiene %d palabras.%n", hashSetDeCuento.size());
		
	}
	
	public static void treeSetPalabras (String [] cuento) {
		
		TreeSet<String> treeSetDeCuento = new TreeSet<>();
		
		for (String c : cuento) {
			treeSetDeCuento.add(c);
		}
		
		System.out.println("TreeSet de palabras");
		System.out.println("===================");
		
		
		for (String palabra : treeSetDeCuento) {
				System.out.printf("[%s]",palabra);	
		}
	
		
		System.out.println();
		System.out.printf("Lista en TreeSet tiene %d palabras.%n", treeSetDeCuento.size());
		
	}
	
	public static void mapConteoPalabras (String [] cuento) {
		
		Map<String, Integer> mapConteoDePalabras = new HashMap<>();
		
		
		for (String palabra : cuento) {
			
			int cantidadDeApariciones = mapConteoDePalabras.getOrDefault(palabra, 0);
			
			mapConteoDePalabras.put(palabra, cantidadDeApariciones + 1);
			
		}
		
		System.out.println("Conteo de repeticiones de palabras");
		System.out.println("==================================");
		
				
		for (String palabra : mapConteoDePalabras.keySet()) {
			System.out.printf("[%s(%d)]%n",palabra, mapConteoDePalabras.get(palabra));
		}
			
		
		
	}
	
	public static void mapConteoPalabrasOrdenadas (String [] cuento) {
		
		TreeMap<String, Integer> treeMapConteoPalabras = new TreeMap<>();
		
		
		for (String palabra : cuento) {
			
			int cantidadDeApariciones = treeMapConteoPalabras.getOrDefault(palabra, 0);
			
			treeMapConteoPalabras.put(palabra, cantidadDeApariciones + 1);
			
		}
		
		System.out.println("Conteo de repeticiones de palabras ordenadas");
		System.out.println("============================================");
		
		for (String palabra : treeMapConteoPalabras.keySet()) {
			System.out.printf("[%s(%d)]%n",palabra, treeMapConteoPalabras.get(palabra));
		}
					
		
		
		
	}
	
	/*POR AHORA NO ES NECESARIO ENFOCARME EN ESTE:
	public static void treeSetPalabrasOrdenadasInversa (String [] cuento) {
		
		TreeSet<String> treeSetPalabrasOrdenadasInversa = new TreeSet<>(Comparator.reverseOrder());
		
		for (String c : cuento) {
			treeSetPalabrasOrdenadasInversa.add(c);
		}
		
		System.out.println("Listado de palabras únicas en orden inverso");
		System.out.println("===========================================");
		
		
		for (String palabra : treeSetPalabrasOrdenadasInversa) {
				System.out.printf("[%s]",palabra);	
		}
	
		
		System.out.println();
		System.out.printf("Lista en TreeSet tiene %d palabras.%n", treeSetPalabrasOrdenadasInversa.size());
		
		
		
	}
	*/
	
	//¿PODRÍA MANEJAR QUE ENTRARA SIEMPRE STRING Y NO UN ARRAY DE STRING?
	
	
	
	public static void main(String[] args) {
		
		String cuentoZorro = CuentaCuentos.cuentoZorro();
		
		System.out.println(cuentoZorro);
		
		/*System.out.println(cuentoZorro); 	
		System.out.println(CuentaCuentos.cuentoLechera()); */

	
		
		String [] arrayCuentoZorro = devuelvePalabras(cuentoZorro);
				
		arrayPalabras(cuentoZorro);
		arrayListPalabras(arrayCuentoZorro);
	    
		hashSetPalabras(arrayCuentoZorro);
		treeSetPalabras(arrayCuentoZorro);
		
		mapConteoPalabras(arrayCuentoZorro);
		mapConteoPalabrasOrdenadas(arrayCuentoZorro);
		
		//treeSetPalabrasOrdenadasInversa(arrayCuentoZorro);
		
		
		
		
		
	}
	
	
}
