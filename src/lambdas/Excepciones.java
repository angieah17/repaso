package lambdas;

import java.io.IOException;

public class Excepciones {
	
	  /*  public static void leerArchivo() throws IOException {
	        throw new IOException("Error de lectura");
	    }
	*/
	  
	public static void leerArchivo() throws IOException {
		
		throw new IOException();
		
	}
	    
	
	
	
	public static void main(String[] args) {
		
		int [] array = {1, 2};
		
		try {
			System.out.println(array[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		} finally {
			System.out.println("Siempre me ejecuto");
		}
		
		String s = null;
		
		try {
		
		s.length();
		} catch (NullPointerException e) {
			e.getMessage();
		}
		
		
		
		
		try {
			int division = 2 / 0 ;
		} catch (ArithmeticException e) {
			
		}
		
	}
	
}
