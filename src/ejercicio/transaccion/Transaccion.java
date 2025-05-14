package ejercicio.transaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Transaccion {
	
	private int id;
	private Double importe;
	private LocalDate fecha;
	private String categoria;
	
	
	public Transaccion(int id, Double importe, LocalDate fecha, String categoria) {
		this.id = id;
		this.importe = importe;
		this.fecha = fecha;
		this.categoria = categoria;
	}
	
	public static void main(String[] args) {
		
		List<Transaccion> transacciones = new ArrayList<Transaccion>();
		
		transacciones.add(new Transaccion(1, 150.50, LocalDate.of(2023, 5, 10), "Alimentos"));
        transacciones.add(new Transaccion(2, null, LocalDate.of(2023, 5, 11), "Transporte"));
        transacciones.add(new Transaccion(3, 75.20, LocalDate.of(2023, 5, 12), null));
        transacciones.add(new Transaccion(4, 200.00, LocalDate.of(2023, 5, 13), "Entretenimiento"));
        transacciones.add(new Transaccion(5, null, LocalDate.of(2023, 5, 14), null));
        transacciones.add(new Transaccion(6, 50.75, LocalDate.of(2023, 5, 15), "Alimentos"));
		
        /*
		Double suma =
        
        transacciones.stream()
        .filter(t -> "Alimentos".equalsIgnoreCase(t.categoria))
        .map(t -> t.importe)
        .map(i -> Optional.ofNullable(i)) //Recordar que el map tira de Function, es decir, entra un objeto y se transforma en otro. Entonces se puede aplicar aquí
        .mapToDouble(opt -> opt.orElse(0.0)) //Aquí o se toma el valor o se pone un 0 en caso de null
        .sum();
        
        System.out.println(suma);
        */
        
        Double suma =
        
        transacciones.stream()
        .filter(t -> "Alimentos".equals(t.categoria))
        .map(t -> t.importe)
        .map(i -> Optional.ofNullable(i))
        .mapToDouble(opt -> opt.orElse(0.0))
        .sum();
        
        
		System.out.println(suma);
		
	}
	
	
}
