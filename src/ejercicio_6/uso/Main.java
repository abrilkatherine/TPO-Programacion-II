package ejercicio_6.uso;

import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();

        pila.inicializarPila();

        pila.apilar(0);
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(5);
        pila.apilar(6);

        float porcentaje = porcentajeElementosParesPila(pila);

        System.out.printf("El porcentaje de pares de la pila es: %.2f%%%n", porcentaje);
    }

    /**
     * Calcula el porcentaje de elementos pares en una pila dada y restaura la pila a su estado original.
     *
     * @param pilaOriginal La pila de la cual se calculará el porcentaje de elementos pares.
     * @return El porcentaje (float) de elementos pares en la pila.
     *
     * Complejidad Algorítmica: Lineal.
     */
    public static float porcentajeElementosParesPila(PilaTDA pilaOriginal) {
        PilaTDA pilaAuxiliar = new Pila();

        int cantidadElementos = 0;
        int cantidadElementosPares = 0;
        float porcentaje = 0;

        pilaAuxiliar.inicializarPila();

        // Transferir elementos de pilaOriginal a pilaAuxiliar, contando elementos y pares
        while (!pilaOriginal.pilaVacia()) {
            int elemento = pilaOriginal.tope();
            cantidadElementos++;

            if (elemento % 2 == 0) {
                cantidadElementosPares++;
            }

            pilaAuxiliar.apilar(elemento);
            pilaOriginal.desapilar();
        }

        // Restaurar pilaOriginal desde pilaAuxiliar
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pilaOriginal.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        // Calcular porcentaje si la cantidad de elementos es mayor a cero
        if (cantidadElementos > 0) {
            porcentaje = ((float) cantidadElementosPares * 100) / cantidadElementos;
        } else {
            porcentaje = 0;
        }

        return porcentaje;
    }
}
