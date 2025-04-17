package stream.counter;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
	private String nombre;
	private List<Counter> contadores;
	
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
		contadores = new ArrayList<Counter>();
	}
	
	public void addCounter (Counter counter) {
		contadores.add(counter);
	}

	public List<Counter> getContadores() {
		return contadores;
	}
	
	
	
	
}
