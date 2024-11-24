package ejercicio_8.uso;

import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {

        ColaTDA colaOriginal = new Cola(); // Crear una cola original con elementos repetidos
        colaOriginal.inicializarCola();

        // Agregar elementos a la cola original
        colaOriginal.acolar(5);
        colaOriginal.acolar(3);
        colaOriginal.acolar(5);
        colaOriginal.acolar(7);
        colaOriginal.acolar(3);
        colaOriginal.acolar(9);

        System.out.println("Cola original:");
        imprimirCola(colaOriginal);

        // Eliminar elementos repetidos
        ColaTDA colaSinRepetidos = eliminarRepetidos(colaOriginal);

        System.out.println("Cola sin repetidos:");
        imprimirCola(colaSinRepetidos);

        System.out.println("Cola original restaurada:");
        imprimirCola(colaOriginal);
    }

    /**
     * Imprime los elementos de una cola, restaurándola a su estado original.
     *
     * @param cola La cola cuyos elementos se deben imprimir.
     */
    public static void imprimirCola(ColaTDA cola) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            System.out.print(elemento + " ");
            cola.desacolar();
            aux.acolar(elemento);
        }
        System.out.println();

        // Restaurar la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }

    /**
     * Devuelve una nueva cola sin elementos repetidos basada en una cola original.
     * Mantiene la cola original sin modificaciones.
     *
     * @param cola La cola original con posibles elementos repetidos.
     * @return Una nueva cola que contiene solo elementos únicos.
     */

    public static ColaTDA eliminarRepetidos(ColaTDA cola) {
        ConjuntoTDA elementosVistos = new Conjunto(); // conjunto auxiliar para elementos elementosVistos
        ColaTDA colaSinDuplicados = new Cola(); //
        ColaTDA colaAux = new Cola(); // cola auxiliar para restaurar la cola original

        elementosVistos.inicializarConjunto();
        colaSinDuplicados.inicializarCola();
        colaAux.inicializarCola();

        // Búsqueda de elementos no repetidos
        while (!cola.colaVacia()) {
            int elemento = cola.primero(); // Se destruye la cola para procesarla
            cola.desacolar();
            colaAux.acolar(elemento); // Se guarda el elemento en la cola auxiliar

            if (!elementosVistos.pertenece(elemento)) {
                elementosVistos.agregar(elemento);
                colaSinDuplicados.acolar(elemento);
            }
        }
        // Restauración de la cola original
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        return colaSinDuplicados;
    }
}
