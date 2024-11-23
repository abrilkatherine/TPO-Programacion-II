package ejercicio_2.uso;
import ejercicio_2.implementacion.ConjuntoMamushka;

public class Main {
	public static void main(String[] args) {
		ConjuntoMamushka conjunto = new ConjuntoMamushka();
		conjunto.inicializar();

		// Agregar elementos repetidos
		conjunto.guardar(1);
		conjunto.guardar(1);
		conjunto.guardar(1);
		conjunto.guardar(2);
		conjunto.guardar(2);
		conjunto.guardar(3);

		// Mostrar el contenido del conjunto
		System.out.println("=== Estado inicial del conjunto ===");
		conjunto.p();

		// Verificar cuántas veces está cada elemento
		System.out.println("El número 1 está " + conjunto.perteneceCant(1) + " veces.");
		System.out.println("El número 2 está " + conjunto.perteneceCant(2) + " veces.");
		System.out.println("El número 3 está " + conjunto.perteneceCant(3) + " veces.");

		// Eliminar un elemento repetido
		System.out.println("\n=== Eliminando una ocurrencia del número 1 ===");
		conjunto.sacar(1); // Debería eliminar solo una ocurrencia de 1
		conjunto.p();
		System.out.println("El número 1 está ahora " + conjunto.perteneceCant(1) + " veces.");

		System.out.println("\n=== Eliminando todas las ocurrencias del número 2 ===");
		conjunto.sacar(2);
		conjunto.sacar(2); // Segunda ocurrencia eliminada
		conjunto.p();
		System.out.println("El número 2 está ahora " + conjunto.perteneceCant(2) + " veces.");
	}
}
