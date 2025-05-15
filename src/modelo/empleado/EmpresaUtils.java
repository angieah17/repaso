package modelo.empleado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class EmpresaUtils {

	
	public static List<Empleado> generarEmpleados (int n){
		
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		for (int i = 0; i < n; i++) {
			try {
				listaEmpleados.add(new Empleado());
			} catch (NivelAccesoInvalidoException e) {
				System.err.println(e.getMessage());
			}
		}
		
		
		
		return listaEmpleados;
		
	}
	
	public static List<Empleado> filtrarPorCriterio (List<Empleado> lista, Predicate<Empleado> criterio){
		
		List<Empleado> listaFiltada = 
		
		lista.stream()
		.filter(criterio)
		.toList();
		
				
		return listaFiltada;
		
		
	}
	
	public static void imprimirPorAntiguedad (List<Empleado> lista, boolean ascendente) {
		
		
		lista.stream()
		.sorted( ascendente ? Comparator.comparingInt(p -> p.getAnioIngreso()) 
				: Comparator.comparingInt(p -> ((Empleado) p).getAnioIngreso()).reversed())
		.forEach(System.out::println);;
		
		
		
	}
	
	public static HashSet<Empleado> empleadosUnicos (List<Empleado> lista) {
		
		HashSet<Empleado> empleadosUnicos = new HashSet<Empleado>();
		
		for (Empleado empleado : lista) {
			empleadosUnicos.add(empleado);
		}

		return empleadosUnicos;
		
		
		
	}
	
	public static Optional<Empleado> buscarEmpleadoSimilar(List<Empleado> lista, Empleado emp){
		
		Optional<Empleado> empleadoSimilar =
		
		lista.stream()
		.filter(e -> e.equals(emp))
		.findFirst();
		
		
		return empleadoSimilar;
	}
	
	
		public static void main(String[] args) {
			
			System.out.println("--------- PROBANDO GENERAR EMPLEADOS ---------");
			
			List<Empleado> listaEmpleados = 
			EmpresaUtils.generarEmpleados(6);
			
			listaEmpleados.forEach(System.out::println);
			
			System.out.println("\n--------- PROBANDO filtrarPorCriterio ---------");
			List<Empleado> listaFiltrada =
			EmpresaUtils.filtrarPorCriterio(listaEmpleados, e -> Departamento.ADMINISTRACION.equals(e.getDepartamento()));
			
			listaFiltrada.forEach(System.out::println);
			
			System.out.println("\n--------- PROBANDO IMPRIMIR POR ANTIGUEDAD ---------");
			System.out.println("Ascendente:");
			EmpresaUtils.imprimirPorAntiguedad(listaEmpleados, true);
			System.out.println("Descendente:");
			EmpresaUtils.imprimirPorAntiguedad(listaEmpleados, false);
			
			System.out.println("\n--------- PROBANDO EMPLEADOS UNICOS ---------");
			listaEmpleados.add(listaEmpleados.get(0));
			listaEmpleados.forEach(System.out::println);
			
			
			System.out.println(EmpresaUtils.empleadosUnicos(listaEmpleados));
			
			
			
			
			
		}
	
	
}
