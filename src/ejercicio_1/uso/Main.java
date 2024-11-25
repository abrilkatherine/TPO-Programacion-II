package ejercicio_1.uso;

import ejercicio_1.implementacion.ConjuntoEspecial;
import ejercicio_1.interfaz.ConjuntoEspecialTDA;

public class Main {
    public static void main(String[] args) {
        probarConjuntoEspecial();
    }

    public static void probarConjuntoEspecial() {
        // Inicializar el conjunto
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecial();
        conjunto.inicializarConjunto();

        // Probar agregar elementos
        System.out.println("\n-- Agregar elementos al conjunto --");
        imprimirResultado(conjunto.agregar(2), "Agregar 2");
        imprimirResultado(conjunto.agregar(3), "Agregar 3");
        imprimirResultado(conjunto.agregar(4), "Agregar 4");

        // Probar elegir un elemento aleatorio
        System.out.println("\n-- Elegir un elemento aleatorio del conjunto --");
        imprimirResultado(conjunto.elegir(), "Elegir un valor");

        // Probar eliminar un elemento que no pertenece
        System.out.println("\n-- Intentar eliminar un elemento inexistente --");
        imprimirResultado(conjunto.sacar(1), "Eliminar 1 (no existe)");

        // Probar eliminar un elemento existente
        System.out.println("\n-- Eliminar un elemento existente --");
        imprimirResultado(conjunto.sacar(2), "Eliminar 2 (existe)");

        // Probar agregar un elemento que ya pertenece
        System.out.println("\n-- Intentar agregar un elemento duplicado --");
        imprimirResultado(conjunto.agregar(3), "Agregar 3 (ya existe)");

        // Probar elegir un elemento después de modificaciones
        System.out.println("\n-- Elegir otro elemento después de modificaciones --");
        imprimirResultado(conjunto.elegir(), "Elegir un valor");

        // Probar conjunto vacío
        System.out.println("\n-- Vaciar el conjunto y probar elegir --");
        conjunto.sacar(3);
        conjunto.sacar(4);
        imprimirResultado(conjunto.elegir(), "Elegir en conjunto vacío");
    }

    /**
     * Metodo auxiliar para imprimir los resultados de las operaciones sobre el conjunto.
     *
     * @param respuesta El objeto Respuesta devuelto por el metodo del TDA.
     * @param operacion La descripción de la operación realizada.
     *
     */
    public static void imprimirResultado(ConjuntoEspecialTDA.Respuesta respuesta, String operacion) {
        System.out.println(operacion + " -> " +
                (respuesta.error ? "Error: " + respuesta.error : "Éxito: Valor = " + respuesta.rta));
    }
}
