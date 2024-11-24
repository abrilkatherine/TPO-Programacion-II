package ejercicio_11.uso;

import imple.Cola;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class Main {

    public static void main(String[] args) {

        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultiple();
        diccionarioMultiple.inicializarDiccionario();

        ColaTDA queue = valoresUnicos(diccionarioMultiple);

        while (!queue.colaVacia()) {
            System.out.println("valores de la queue: " + queue.primero());
            queue.desacolar();
        }

    }

    public static ColaTDA valoresUnicos(DiccionarioMultipleTDA diccionarioMultiple) {

        ColaTDA queue = new Cola();
        queue.inicializarCola();
        ConjuntoTDA claves = diccionarioMultiple.claves();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            ConjuntoTDA valores = diccionarioMultiple.recuperar(clave);
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);

                if (!contieneValor(queue, valor)) {
                    queue.acolar(valor);
                }
            }

        }
        return queue;
    }


    private static boolean contieneValor(ColaTDA cola, int valor) {
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        boolean encontrado = false;

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            colaAux.acolar(elemento);
            if (elemento == valor) {
                encontrado = true;
            }
        }

        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return encontrado;
    }
}
