package ejercicio_7.uso;

import imple.Conjunto;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class Main {
    public static void main(String[] args) {

        PilaTDA pila = new Pila(); // Crear una instancia de la pila
        pila.inicializarPila();

        // Agregar elementos a la pila
        pila.apilar(3);
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(7);
        pila.apilar(5);
        pila.apilar(9);

        ConjuntoTDA repetidos = devolverElementosRepetidos(pila);

        // Mostrar los elementos repetidos
        System.out.print("Elementos repetidos de la Pila: ");
        while (!repetidos.conjuntoVacio()) {
            int elemento = repetidos.elegir();
            System.out.print(elemento + " ");
            repetidos.sacar(elemento);
        }
    }

    /*
    Verifica los elementos repetidos de una pila y los devuelve en un conjunto.
    El metodo utiliza un conjunto y una pila auxiliares para el procesamiento.
    Primero se extraen los datos de la pila para procesar y luego se guardan en una pila auxiliar para
    restaurar la original.
    Se utiliza el conjunto unicos para almacenar la primera aparicion de un valor, para luego comparar con
    los siguientes valores de la pila. Si el elemento ya fue procesado anteriormente, se guarda en el nuevo
    conjunto.
    Complejidad Algorítmica: Lineal
    */
    
    public static ConjuntoTDA devolverElementosRepetidos(PilaTDA pila) {
        ConjuntoTDA unicos = new Conjunto(); // conjunto auxiliar para elementos únicos
        ConjuntoTDA repetidos = new Conjunto(); // conjunto a retornar con elementos repetidos
        PilaTDA aux = new Pila(); // pila auxiliar para restaurar la pila original
        // Inicialización de pilas y conjuntos
        unicos.inicializarConjunto();
        repetidos.inicializarConjunto();
        aux.inicializarPila();

        while (!pila.pilaVacia()) { // Búsqueda de elementos repetidos
            int elemento = pila.tope(); // Se destruye la pila para procesarla
            pila.desapilar();
            aux.apilar(elemento); // Se guarda el dato en la pila auxiliar para reconstruir la pila original
            if (unicos.pertenece(elemento)) {
                repetidos.agregar(elemento); // Si el elemento existe, se agrega al conjunto de repetidos
            } else {
                unicos.agregar(elemento); // Si no es repetido, se agrega al conjunto de únicos
            }
        }

        while (!aux.pilaVacia()) { // Reconstrucción de pila original
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return repetidos;
    }
}
