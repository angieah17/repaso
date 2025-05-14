package ejercicio.producto;

import java.util.ArrayList;
import java.util.List;

public class Run {
	
	private static Producto buscarProducto (List<Producto> lista, int id) throws ProductoNoEncontradoException {
		
		return 
		lista.stream().
		filter(p -> p.getId() == id)
		.findFirst()
		.orElseThrow(() -> new ProductoNoEncontradoException("Producto NO encontrado"));
		
		
	}
	
	private static void disminuirStock(List<Producto> inventario, int id, int cantidad) throws InventarioInsuficienteException, ProductoNoEncontradoException {
        Producto producto = buscarProducto(inventario, id);
        if (producto.getCantidad() < cantidad) {
            throw new InventarioInsuficienteException("No hay suficiente stock para el producto ID " + id);
        }
        producto.setCantidad(producto.getCantidad() - cantidad);
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
	        
	  
	  try {
		Run.disminuirStock(inventario, 1, 100);
	} catch (InventarioInsuficienteException e) {
		System.out.println(e.getMessage());
		
	} catch (ProductoNoEncontradoException e) {
		System.out.println(e.getMessage());
	}
	  
	        
	}
	
	
}
