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
     * Recorre los elementos de la cola original y los imprime en el
     * orden en que aparecen, utilizando una cola auxiliar para preservar su
     * contenido.
     *
     * @param cola La cola cuyos elementos se deben imprimir.
     * @implNote Complejidad: Lineal.
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
     * Utiliza un conjunto para rastrear elementos únicos mientras recorre la cola original. Cualquier elemento ya visto
     * es ignorado al construir la nueva cola. La cola original se restaura tras el proceso.
     *
     * @param cola La cola original con posibles elementos repetidos.
     * @return Una nueva cola que contiene solo elementos únicos, en el mismo orden en que aparecían en la cola original.
     *
     */
    public static ColaTDA eliminarRepetidos(ColaTDA cola) {
        ConjuntoTDA elementosVistos = new Conjunto(); // Conjunto auxiliar para almacenar elementos únicos
        ColaTDA colaSinDuplicados = new Cola(); // Cola para elementos no repetidos
        ColaTDA colaAux = new Cola(); // Cola auxiliar para restaurar la cola original

        elementosVistos.inicializarConjunto();
        colaSinDuplicados.inicializarCola();
        colaAux.inicializarCola();

        // Recorrer los elementos de la cola original
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            colaAux.acolar(elemento); // Guardar el elemento en la cola auxiliar

            if (!elementosVistos.pertenece(elemento)) { // Verificar si el elemento es único
                elementosVistos.agregar(elemento);
                colaSinDuplicados.acolar(elemento);
            }
        }

        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        return colaSinDuplicados;
    }
}
