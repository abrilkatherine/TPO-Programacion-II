package ejercicio_4.uso;

import ejercicio_4.implementacion.DiccionarioSimpleMod;
import ejercicio_4.interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        probarDiccionarioSimpleMod();
    }

    /**
     * Metodo principal para realizar pruebas del TDA DiccionarioSimpleMod.
     * Realiza operaciones de agregar, modificar, eliminar y recuperar claves,
     * valores y factores de modificación.
     */
    public static void probarDiccionarioSimpleMod() {
        DiccionarioSimpleModTDA diccionario = new DiccionarioSimpleMod();
        diccionario.inicializarDiccionario();

        // Prueba 1: Agregar claves nuevas
        System.out.println("\n--- Agregando claves nuevas ---");
        diccionario.agregar(3, 25);
        diccionario.agregar(4, 100);
        diccionario.agregar(1, 50);
        mostrarClaves(diccionario);

        // Prueba 2: Modificar una clave existente
        System.out.println("\n--- Modificando clave existente ---");
        diccionario.agregar(3, 34); // Modificar valor de clave 3
        diccionario.agregar(3, 90); // Modificar valor de clave 3 nuevamente
        mostrarFactorMod(diccionario, 3);

        // Prueba 3: Recuperar valores
        System.out.println("\n--- Recuperando valores ---");
        mostrarValor(diccionario, 3);
        mostrarValor(diccionario, 4);
        mostrarValor(diccionario, 1);

        // Prueba 4: Recuperar factor de modificaciones
        System.out.println("\n--- Factores de modificación ---");
        mostrarFactorMod(diccionario, 1);
        mostrarFactorMod(diccionario, 3);
        mostrarFactorMod(diccionario, 4);

        // Prueba 5: Eliminar una clave
        System.out.println("\n--- Eliminando clave 4 ---");
        diccionario.eliminar(4);
        mostrarClaves(diccionario);

        // Prueba 6: Intentar recuperar una clave eliminada
        System.out.println("\n--- Intentando recuperar clave eliminada ---");
        if (claveExiste(diccionario, 4)) {
            mostrarValor(diccionario, 4);
        } else {
            System.out.println("Clave 4 no encontrada (correcto).");
        }

        // Prueba 7: Recuperar claves restantes
        System.out.println("\n--- Claves restantes ---");
        mostrarClaves(diccionario);
    }

    /**
     * Muestra todas las claves almacenadas en el diccionario.
     *
     * @param diccionario DiccionarioSimpleModTDA del cual se mostrarán las claves.
     *
     * @implNote Complejidad: Lineal..
     */
    private static void mostrarClaves(DiccionarioSimpleModTDA diccionario) {
        System.out.print("Claves actuales: ");
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print(clave + " ");
            claves.sacar(clave);
        }
        System.out.println();
    }

    /**
     * Muestra el valor asociado a una clave específica.
     *
     * @param diccionario DiccionarioSimpleModTDA del cual se recuperará el valor.
     * @param clave Clave cuyo valor asociado se desea mostrar.
     * @implNote Complejidad: Lineal.
     */
    private static void mostrarValor(DiccionarioSimpleModTDA diccionario, int clave) {
        System.out.println("Valor de clave " + clave + ": " + diccionario.recuperar(clave));
    }

    /**
     * Muestra el factor de modificaciones de una clave específica.
     *
     * @param diccionario DiccionarioSimpleModTDA del cual se recuperará el factor de modificaciones.
     * @param clave Clave cuyo factor de modificaciones se desea mostrar.
     * @implNote Complejidad: Lineal.
     */
    private static void mostrarFactorMod(DiccionarioSimpleModTDA diccionario, int clave) {
        System.out.println("Factor de modificaciones de clave " + clave + ": " + diccionario.recuperarMod(clave));
    }

    /**
     * Verifica si una clave existe en el diccionario.
     *
     * @param diccionario DiccionarioSimpleModTDA en el cual se buscará la clave.
     * @param clave Clave que se desea verificar.
     * @return true si la clave existe en el diccionario, false en caso contrario.
     *
     * @implNote Complejidad: Lineal.
     */
    private static boolean claveExiste(DiccionarioSimpleModTDA diccionario, int clave) {
        ConjuntoTDA claves = diccionario.claves();
        boolean existe = false;
        while (!claves.conjuntoVacio()) {
            int actual = claves.elegir();
            if (actual == clave) {
                existe = true;
            }
            claves.sacar(actual);
        }
        return existe;
    }
}
