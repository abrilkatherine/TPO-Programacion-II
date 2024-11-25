package ejercicio_5.uso;

import ejercicio_5.implementacion.DiccionarioSimple;
import ejercicio_5.interfaz.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        probarDiccionarioSimple();
    }

    /**
     * Prueba el correcto funcionamiento de DiccionarioSimpleTDA implementado
     * usando únicamente una ColaPrioridadTDA.
     */
    public static void probarDiccionarioSimple() {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimple();
        diccionario.inicializarDiccionario();

        System.out.println("=== Pruebas del DiccionarioSimpleTDA ===");

        // Prueba 1: Agregar claves y valores
        System.out.println("\n--- Agregando claves y valores ---");
        diccionario.agregar(3, 40);
        diccionario.agregar(5, 90);
        diccionario.agregar(2, 70);
        mostrarClaves(diccionario);

        // Prueba 2: Recuperar valores
        System.out.println("\n--- Recuperando valores ---");
        System.out.println("Valor asociado a la clave 3: " + diccionario.recuperar(3));
        System.out.println("Valor asociado a la clave 5: " + diccionario.recuperar(5));
        System.out.println("Valor asociado a la clave 2: " + diccionario.recuperar(2));

        // Prueba 3: Eliminar una clave
        System.out.println("\n--- Eliminando clave 5 ---");
        diccionario.eliminar(5);
        System.out.println("Clave 5 eliminada.");
        mostrarClaves(diccionario);

        // Prueba 4: Intentar recuperar una clave eliminada
        System.out.println("\n--- Intentando recuperar clave eliminada ---");
        System.out.println("Valor asociado a la clave 5 (esperado 0): " + diccionario.recuperar(5));

        // Prueba 5: Verificar claves restantes
        System.out.println("\n--- Claves restantes en el diccionario ---");
        mostrarClaves(diccionario);

        // Prueba 6: Reemplazar valores existentes
        System.out.println("\n--- Reemplazando valores de claves existentes ---");
        diccionario.agregar(3, 100);
        diccionario.agregar(2, 50);
        mostrarClaves(diccionario);
        System.out.println("Valor actualizado de la clave 3: " + diccionario.recuperar(3));
        System.out.println("Valor actualizado de la clave 2: " + diccionario.recuperar(2));
    }

    /**
     * Muestra todas las claves presentes en el diccionario.
     *
     * @param diccionario DiccionarioSimpleTDA del cual se extraerán las claves.
     */
    private static void mostrarClaves(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        System.out.print("Claves actuales: ");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print(clave + " ");
            claves.sacar(clave);
        }
        System.out.println();
    }
}
