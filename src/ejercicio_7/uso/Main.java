package ejercicio_7.uso;

import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {

        PilaTDA pila = new Pila();
        pila.inicializarPila();

        // Agregar elementos a la pila
        pila.apilar(3);
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(7);
        pila.apilar(5);
        pila.apilar(9);

        // Encontrar elementos repetidos en la pila
        ConjuntoTDA repetidos = devolverElementosRepetidos(pila);

        // Mostrar los elementos repetidos
        System.out.print("Elementos repetidos de la Pila: ");
        while (!repetidos.conjuntoVacio()) {
            int elemento = repetidos.elegir();
            System.out.print(elemento + " ");
            repetidos.sacar(elemento);
        }
    }

    /**
     * Encuentra los elementos repetidos en una pila y los devuelve en un conjunto.
     *
     * Utiliza un conjunto para almacenar los elementos únicos y otro para los repetidos.
     * La pila original se restaura tras procesar los datos.
     *
     * @param pila Pila de la que se identifican los elementos repetidos. Queda restaurada tras la ejecución.
     * @return Conjunto con los elementos repetidos encontrados en la pila.
     *
     */
    public static ConjuntoTDA devolverElementosRepetidos(PilaTDA pila) {
        ConjuntoTDA unicos = new Conjunto(); // conjunto auxiliar para elementos únicos
        ConjuntoTDA repetidos = new Conjunto(); // conjunto a retornar con elementos repetidos
        PilaTDA pilaAux = new Pila(); // pila auxiliar para restaurar la pila original

        unicos.inicializarConjunto();
        repetidos.inicializarConjunto();
        pilaAux.inicializarPila();

        while (!pila.pilaVacia()) { // Búsqueda de elementos repetidos
            int elemento = pila.tope();
            pila.desapilar();
            pilaAux.apilar(elemento); // Se guarda el dato en la pila auxiliar
            if (unicos.pertenece(elemento)) {
                repetidos.agregar(elemento); // Si el elemento existe, se agrega al conjunto de repetidos
            } else {
                unicos.agregar(elemento); // Si no es repetido, se agrega al conjunto de únicos
            }
        }

        while (!pilaAux.pilaVacia()) { // Reconstrucción de pila original
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return repetidos;
    }
}
