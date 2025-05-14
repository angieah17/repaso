package ejercicio.producto;

import java.util.ArrayList;
import java.util.List;

public class Run {
	
	private static Producto buscarProducto (List<Producto> lista, int id) throws ProductoNoEncontradoException {
		
		
		
		
		throw new ProductoNoEncontradoException("Producto NO encontrado");
		
		/*System.out.println(lista.get(id));
		
		return lista.get(id);*/
		
	}
	
	public static void main(String[] args) {
		
		List<Producto> inventario = new ArrayList<Producto>();
		
		 	inventario.add(new Producto(1, "Laptop", 10));
	        inventario.add(new Producto(2, "Teléfono", 25));
	        inventario.add(new Producto(3, "Tablet", 15));
	        inventario.add(new Producto(4, "Monitor", 8));
	        inventario.add(new Producto(5, "Teclado", 30));
		
	        
	  try {
		Run.buscarProducto(inventario, 9);
	} catch (ProductoNoEncontradoException e) {
		System.out.println(e.getMessage());
	}     
	        
	        
	        
	}
	
	
}
