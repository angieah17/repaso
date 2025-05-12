package lambdas;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Lambdas {

	public static void main(String[] args) {
		
		//PARTE TEÓRICA A
		
		// Ejercicio 1
		
		Function<Integer, Integer> lambda1a = k -> 7;
		
		Function<Integer, Integer> lambda1b = (Integer k) -> {return 7;} ; 
		
		System.out.println(lambda1a.apply(6));
		System.out.println(lambda1b.apply(5));
		
		//Ejercicio 2
		
		Supplier<Boolean> lambda2a = () -> true;
		Supplier<Boolean> lambda2b = () -> {return true;};
		
		System.out.println(lambda2a.get());
		System.out.println(lambda2b.get());
		
		//Ejercicio 3
		
		BiPredicate<Integer, Integer> lambda3a = (a, b) -> a + b < 10;
		BiPredicate<Integer, Integer> lambda3b = (Integer a, Integer b) -> {return a + b < 10 ;};
		System.out.println(lambda3a.test(5, 4));
		System.out.println(lambda3b.test(5, 4));
		
		//Ejercicio 4
		
		Function<Object, String> lambda4a = a -> a.toString();
		Function<Object, String> lambda4b = (Object a) -> {return a.toString();};
		
		//Ejercicio 5
		
		BinaryOperator<Integer> lambda5a = (a, b) -> a + b;
		BinaryOperator<Integer> lambda5b = (Integer a, Integer b) -> {return a + b; };
		System.out.println(lambda5a.apply(5,4));
		System.out.println(lambda5b.apply(5,4));

		//Ejercicio 6
		
		UnaryOperator<Integer> lambda6a = p -> p * p * p;
		UnaryOperator<Integer> lambda6b = (Integer p) -> {return p * p * p;}; 
		
		System.out.println(lambda6a.apply(5));
		System.out.println(lambda6b.apply(5));
		
		//Ejercicio 7
		
		Predicate<Integer> lambda7a = a -> a > 10;
		Predicate<Integer> lambda7b = (Integer a) -> {return a < 10;};
		System.out.println(lambda7a.test(6));
		System.out.println(lambda7b.test(6));
		
		//PARTE B 
		//Ejercicio 1
		
		BiConsumer<Integer, Integer> mensaje = (a, b) -> System.out.printf("%d y %d%n", a, b);
		
		mensaje.accept(1,2);
		
		//Ejercicio 2
		
		BiPredicate<Integer, Integer> mayorQue = (a, b) -> a < b;
		System.out.println(mayorQue.test(1,2));
		
		//Ejercicio 3
		
		BiFunction<String, String, String> concatenar = (s1, s2) -> s1 + s2;
		String resultado = concatenar.apply("Hola", "Mundo"); // Devuelve "HolaMundo" (objeto String)
		
		System.out.println(resultado);
		
	}

}
