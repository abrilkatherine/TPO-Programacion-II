package ejercicio_11.uso;

import imple.*;
import tda.*;

public class Main {

    public static void main(String[] args) {

        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultiple();
        diccionarioMultiple.inicializarDiccionario();
        diccionarioMultiple.agregar(1, 11);
        diccionarioMultiple.agregar(2, 11);
        diccionarioMultiple.agregar(3, 43);
        diccionarioMultiple.agregar(9, 32);
        diccionarioMultiple.agregar(19, 1);
        diccionarioMultiple.agregar(32, 11);


        ColaTDA cola = valoresUnicos(diccionarioMultiple);

        while (!cola.colaVacia()) {
            System.out.println("valores de la queue: " + cola.primero());
            cola.desacolar();
        }

    }

    /**
     * Obtiene una cola con los valores únicos presentes en un diccionario múltiple.
     *
     * @param diccionarioMultiple el diccionario múltiple del cual se obtendrán los valores únicos
     * @return una cola con los valores únicos presentes en el diccionario múltiple
     * COSTO POLINOMICO
     */

    public static ColaTDA valoresUnicos(DiccionarioMultipleTDA diccionarioMultiple) {

        ColaTDA cola = new Cola();
        cola.inicializarCola();
        ConjuntoTDA claves = diccionarioMultiple.claves();
        ConjuntoTDA valoresUnicos = new Conjunto();
        valoresUnicos.inicializarConjunto();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = diccionarioMultiple.recuperar(clave);
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);
                if (!valoresUnicos.pertenece(valor)) {
                    valoresUnicos.agregar(valor); // Añadir al conjunto de valores únicos
                    cola.acolar(valor);         // Añadir a la cola
                }
            }
        }
        return cola;
    }


}
