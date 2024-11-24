package ejercicio_9.uso;

import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        ColaTDA cola = new Cola();
        pila.inicializarPila();
        cola.inicializarCola();

        // Agregar elementos a la pila
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(7);
        pila.apilar(2);

        // Agregar elementos a la cola
        cola.acolar(7);
        cola.acolar(3);
        cola.acolar(9);
        cola.acolar(1);

        ConjuntoTDA comunes = obtenerElementosComunes(pila, cola);

        // Mostrar los elementos comunes con comas entre ellos
        System.out.print("Elementos comunes entre Pila y Cola: ");
        boolean primero = true; // Bandera para saber si es el primer elemento
        while (!comunes.conjuntoVacio()) {
            int elemento = comunes.elegir();
            if (!primero) {
                System.out.print(", "); // Agregar coma antes del elemento si no es el primero
            }
            System.out.print(elemento);
            comunes.sacar(elemento);
            primero = false;
        }
    }

    /**
     * @param pila La pila cuyos elementos se compararán con la cola.
     * @param cola La cola cuyos elementos se compararán con la pila.
     * @return Un conjunto que contiene los elementos comunes entre la pila y la cola.
     *
     * @implNote Complejidad algorítmica: Polinómica.
     */
    public static ConjuntoTDA obtenerElementosComunes(PilaTDA pila, ColaTDA cola) {
        // Conjunto auxiliar para almacenar los elementos de la pila (evita duplicados)
        ConjuntoTDA elementosPila = new Conjunto();
        // Conjunto para guardar los elementos comunes entre la pila y la cola
        ConjuntoTDA comunes = new Conjunto();

        PilaTDA auxPila = new Pila();
        ColaTDA auxCola = new Cola();

        // Inicializar los conjuntos y las estructuras auxiliares
        elementosPila.inicializarConjunto();
        comunes.inicializarConjunto();
        auxPila.inicializarPila();
        auxCola.inicializarCola();

        // Procesar la pila:
        // Extraer todos los elementos de la pila y almacenarlos en el conjunto elementosPila
        while (!pila.pilaVacia()) {
            int elemento = pila.tope(); // Obtener el elemento en el tope de la pila
            pila.desapilar(); // Eliminar el elemento de la pila
            auxPila.apilar(elemento); // Almacenar el elemento en la pila auxiliar para restaurar después
            elementosPila.agregar(elemento); // Agregar el elemento al conjunto auxiliar
        }

        // Procesar la cola:
        // Comparar los elementos de la cola con el conjunto elementosPila
        while (!cola.colaVacia()) {
            int elemento = cola.primero(); // Obtener el elemento al frente de la cola
            cola.desacolar(); // Eliminar el elemento de la cola
            auxCola.acolar(elemento); // Almacenar el elemento en la cola auxiliar para restaurar después
            // Verificar si el elemento de la cola está en el conjunto elementosPila
            if (elementosPila.pertenece(elemento)) {
                comunes.agregar(elemento); // Agregar el elemento al conjunto comunes si pertenece
            }
        }

        // Restaurar la pila original
        while (!auxPila.pilaVacia()) {
            pila.apilar(auxPila.tope());
            auxPila.desapilar();
        }

        // Restauramos la cola original
        while (!auxCola.colaVacia()) {
            cola.acolar(auxCola.primero());
            auxCola.desacolar();
        }

        return comunes;
    }
}
