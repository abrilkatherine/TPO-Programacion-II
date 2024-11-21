import implementacion.DiccionarioSimpleMod;
import interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        probarDiccionarioSimpleMod(); // Ej 4
    }

    /** Ejercicio 4 **/
    private static void probarDiccionarioSimpleMod() {
        // Crear e inicializar el diccionario
        DiccionarioSimpleModTDA diccionario = new DiccionarioSimpleMod();
        diccionario.inicializarDiccionario();

        // Agregar algunas claves y valores
        System.out.println("Agregando claves y valores iniciales...");
        diccionario.agregar(1, 100);
        diccionario.agregar(2, 200);
        diccionario.agregar(3, 300);
        mostrarEstadoDiccionario(diccionario);

        // Modificar valores existentes
        System.out.println("\nModificando valores de claves existentes...");
        diccionario.agregar(2, 250);
        diccionario.agregar(3, 350);
        diccionario.agregar(3, 375); // Modificar nuevamente la clave 3
        mostrarEstadoDiccionario(diccionario);

        // Eliminar una clave
        System.out.println("\nEliminando la clave 1...");
        diccionario.eliminar(1);
        mostrarEstadoDiccionario(diccionario);

        // Intentar recuperar una clave eliminada
        System.out.println("\nIntentando recuperar el valor de la clave eliminada 1...");
        try {
            int valor = diccionario.recuperar(1);
            System.out.println("Valor para clave 1: " + valor);
        } catch (NoSuchElementException e) {
            System.out.println("Clave 1 no encontrada.");
        }

        // Mostrar todas las claves actuales
        System.out.println("\nClaves actuales en el diccionario:");
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.println("Clave: " + clave);
            claves.sacar(clave);
        }
    }

    private static void mostrarEstadoDiccionario(DiccionarioSimpleModTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        System.out.println("Estado actual del diccionario:");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int valor = diccionario.recuperar(clave);
            int modificacion = diccionario.recuperarMod(clave);
            System.out.println("Clave: " + clave + ", Valor: " + valor + ", Modificaciones: " + modificacion);
            claves.sacar(clave);
        }
    }
}
