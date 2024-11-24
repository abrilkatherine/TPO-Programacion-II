package Ejercicio_12.uso;

import imple.ABB;
import tda.ABBTDA;

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


    public static int sumaImpares(ABBTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        } else {
            // Suma los valores impares del subárbol
            int suma = sumaImpares(abb.hijoIzq());
            //si la raiz es impar, se suma
            if (abb.raiz() % 2 != 0) {
                suma += abb.raiz();
            }
            // Se suma los valores impares del subárbol derecho
            suma += sumaImpares(abb.hijoDer());
            return suma;
        }
    }


}
