package Ejercicio_12.uso;

import imple.*;
import tda.*;

public class Main {

    public static void main(String[] args) {

        ABBTDA abb = new ABB();
        abb.inicializarArbol();
        abb.agregarElem(10);
        abb.agregarElem(5);
        abb.agregarElem(3);
        abb.agregarElem(12);
        abb.agregarElem(9);
        abb.agregarElem(14);

        System.out.println("la suma de los impares es: " + sumaImpares(abb));
    }

    /**
     * Recorre el árbol en forma recursiva, verificando si el nodo actual
     * contiene un valor impar. Si es impar, se agrega a la suma total. La recursión
     * asegura que se procesen todos los nodos del árbol, visitando primero el subárbol
     * izquierdo, luego la raíz, y finalmente el subárbol derecho.
     *
     * @param abb Árbol binario de búsqueda (ABB) cuyos valores se analizarán.
     * @return La suma de los valores impares en el árbol.
     *
     */

    public static int sumaImpares(ABBTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        } else {
            int suma = sumaImpares(abb.hijoIzq()); // Suma los valores impares del subárbol
            if (abb.raiz() % 2 != 0) {  //si la raiz es impar, se suma
                suma += abb.raiz();
            }
            suma += sumaImpares(abb.hijoDer()); // Se suma los valores impares del subárbol derecho
            return suma;
        }
    }
}
