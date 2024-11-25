package ejercicio_13.uso;

import imple.*;
import tda.*;

public class Main {

    public static void main(String[] args) {
        ABB arbol = new ABB();
        arbol.inicializarArbol();
        arbol.agregarElem(10);
        arbol.agregarElem(5);
        arbol.agregarElem(15);
        arbol.agregarElem(2);
        arbol.agregarElem(800);

        int resultado = cantidadHojasPares(arbol);
        System.out.println("Cantidad de hojas con valor par: " + resultado);
    }

    /**
     *
     * Recorre el árbol en forma recursiva, verificando si cada hoja tiene un valor par. Si el nodo actual es una hoja
     * y su valor es par, se cuenta. La recursión asegura que se evalúen todas las hojas del árbol.
     *
     * @param arbol Árbol binario de búsqueda (ABB) cuyos nodos se analizarán.
     * @return La cantidad de hojas con valores pares en el árbol.
     *
     */

    public static int cantidadHojasPares(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0; // Caso base: árbol vacío
        }

        // Verificar si el nodo actual es una hoja
        if (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio()) {
            return (arbol.raiz() % 2 == 0) ? 1 : 0; // Contar si es hoja par
        }

        // Recursión sobre los subárboles izquierdo y derecho
        int hojasParesIzq = cantidadHojasPares(arbol.hijoIzq());
        int hojasParesDer = cantidadHojasPares(arbol.hijoDer());

        return hojasParesIzq + hojasParesDer;
    }
}
