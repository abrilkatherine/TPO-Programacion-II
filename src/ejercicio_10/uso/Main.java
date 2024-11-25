package ejercicio_10.uso;


import imple.*;
import tda.*;
public class Main {

    public static void main(String[] args) {
        // Inicializar una pila y agregar elementos
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(3);
        pila.apilar(2);

        // Transformar la pila en un diccionario simple
        DiccionarioSimpleTDA diccionarioSimple = transformarPilaEnDiccionarioSimple(pila);

        // Imprime los elementos del diccionario
        System.out.println("Contenido del Diccionario:");
        ConjuntoTDA claves = diccionarioSimple.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.println("Clave: " + clave + ", Valor: " + diccionarioSimple.recuperar(clave));
            claves.sacar(clave);
        }
    }

    /**
     * Transforma una pila en un diccionario simple donde las claves son los elementos de la pila
     * y los valores son la cantidad de veces que cada elemento aparece en la pila.
     *
     * @param pila la pila de la cual se obtendrán los elementos para el diccionario
     * @return un diccionario simple con los elementos de la pila y sus respectivas frecuencias
     *
     * @implNote Complejidad: Polinomica.
     */

    public static DiccionarioSimpleTDA transformarPilaEnDiccionarioSimple(PilaTDA pila) {
        DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimple();
        diccionarioSimple.inicializarDiccionario();

        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();

        // Recorre la pila original para contar las apariciones de cada elemento
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            pilaAux.apilar(elemento); // Copia el elemento en la pila auxiliar.

            // Verifica si la clave ya existe en el diccionario antes de recuperarla.
            ConjuntoTDA claves = diccionarioSimple.claves();
            boolean existe = false;

            // Itera por las claves para verificar si el elemento ya está presente.
            while (!claves.conjuntoVacio()) {
                int clave = claves.elegir();
                if (clave == elemento) {
                    existe = true;
                }
                claves.sacar(clave);
            }

            // Si la clave existe, recupera y actualiza el valor
            if (existe) {
                int contador = diccionarioSimple.recuperar(elemento);
                diccionarioSimple.agregar(elemento, contador + 1);
            } else {
                // Si no existe, agrégala con un valor inicial de 1
                diccionarioSimple.agregar(elemento, 1);
            }
        }

        // Restaura la pila original desde la pila auxiliar
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return diccionarioSimple;
    }
}
