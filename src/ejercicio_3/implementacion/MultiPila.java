package ejercicio_3.implementacion;

import ejercicio_3.interfaz.MultiPilaTDA;
import tda.PilaTDA;
import imple.Pila;

public class MultiPila implements MultiPilaTDA {

    private class Nodo {
        int info; // Dato del nodo
        Nodo sig; // Apunta al siguiente nodo
    }

    private Nodo primero; // Referencia al primer nodo de la pila múltiple
    private int tamanio; // Tamaño de la pila múltiple

    public void apilar(PilaTDA valores) { // Complejidad:Lineal 
        if (valores.pilaVacia()) { // Si la pila está vacía, no hace nada.
            return;
        }

        int x = valores.tope(); // Obtiene el elemento en la cima de la pila "valores".
        valores.desapilar(); // Saca el elemento de la pila "valores".

        apilar(valores); // Llamada recursiva para apilar los elementos restantes.

        Nodo nuevo = new Nodo(); // Crea un nuevo nodo.
        nuevo.info = x; // Asigna el valor del elemento actual al nodo.
        nuevo.sig = primero; // Inserta el nodo al principio de la pila múltiple.
        primero = nuevo; // Actualiza el puntero "primero" al nuevo nodo.
        tamanio++; // Incrementa el tamaño de la pila múltiple.

        valores.apilar(x); // Vuelve a apilar el elemento original en "valores".
    }

    public void desapilar(PilaTDA valores) { // Complejidad:Lineal 
        Nodo actual = primero; // Nodo actual comienza desde el primero.
        PilaTDA temp = new Pila(); // Pila temporal para almacenar los elementos que coinciden.
        temp.inicializarPila();

        // Busca elementos en común entre la pila múltiple y "valores".
        while (actual != null && !valores.pilaVacia() && actual.info == valores.tope()) {
            temp.apilar(actual.info); // Apila el elemento actual en "temp".
            valores.desapilar(); // Saca el elemento coincidente de "valores".
            actual = actual.sig; // Avanza al siguiente nodo en la pila múltiple.
        }

        if (valores.pilaVacia()) { // Si se recorrió completamente "valores"...
            while (!temp.pilaVacia()) { // Elimina los elementos coincidentes de la pila múltiple.
                primero = primero.sig; // Avanza al siguiente nodo.
                tamanio--; // Decrementa el tamaño de la pila múltiple.
                temp.desapilar(); // Saca el elemento de la pila temporal.
            }
        }

        // Restaura los elementos de "temp" a "valores".
        while (!temp.pilaVacia()) {
            valores.apilar(temp.tope()); // Apila el elemento en "valores".
            temp.desapilar(); // Saca el elemento de la pila temporal.
        }
    }

    public PilaTDA tope(int cantidad) { // Complejidad:Lineal 
        PilaTDA pilaAux = new Pila(); // Pila auxiliar para devolver los elementos.
        pilaAux.inicializarPila();
        PilaTDA temp = new Pila(); // Pila temporal para invertir el orden.
        temp.inicializarPila();

        Nodo actual = primero; // Nodo actual comienza desde el primero.
        int elementosAIncluir = Math.min(cantidad, this.tamanio); // Determina la cantidad de elementos a incluir.

        // Copia los elementos requeridos en la pila temporal.
        for (int j = 0; j < elementosAIncluir; j++) {
            if (actual != null) {
                temp.apilar(actual.info); // Apila el elemento en "temp".
                actual = actual.sig; // Avanza al siguiente nodo.
            }
        }

        // Invierte el orden para mantener el original.
        while (!temp.pilaVacia()) {
            pilaAux.apilar(temp.tope()); // Apila en "pilaAux".
            temp.desapilar(); // Saca el elemento de "temp".
        }

        return pilaAux; // Devuelve la pila auxiliar.
    }

    public void inicializarMultiPila() { // Complejidad: Constante
        tamanio = 0; // Inicializa el tamaño a 0.
        primero = null; // La pila queda vacía.
    }

    public boolean pilaVacia() { // Complejidad: Constante
        return (primero == null); // Devuelve si la pila múltiple está vacía.
    }
}