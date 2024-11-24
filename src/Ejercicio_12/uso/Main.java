package Ejercicio_12.uso;

import imple.ABB;
import tda.ABBTDA;

public class Main {

    public static void main(String[] args) {

        ABBTDA abb = new ABB();
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
            int suma = sumaImpares(abb.hijoIzq());
            if (abb.raiz() % 2 != 0) {
                suma += abb.raiz();
            }
            suma += sumaImpares(abb.hijoDer());
            return suma;
        }
    }


}
