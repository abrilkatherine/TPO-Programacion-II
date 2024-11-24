package ejercicio_14.uso;

import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(2, 5, 1);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(4, 5, 1);

        ConjuntoTDA puente = puente(grafo, 1, 5);

        while (!puente.conjuntoVacio()) {
            int p = puente.elegir();
            System.out.println(p);
            puente.sacar(p);
        }
    }

    /**
     * @param grafo El grafo sobre el cual se realizará la búsqueda.
     * @param origen El vértice de origen.
     * @param destino El vértice de destino.
     * @return Un conjunto con los vértices puente entre \(origen\) y \(destino\).
     *
     * @implNote Complejidad: Exponencial.
     */
    public static ConjuntoTDA puente(GrafoTDA grafo, int origen, int destino) { // Complejidad: Exponencial
        ConjuntoTDA puente = new Conjunto();
        puente.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        // Verificar todos los posibles vértices p en el grafo
        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            // Si p no es origen ni destino, verificar si p es puente entre origen y destino
            if (p != origen && p != destino && grafo.existeArista(origen, p) && grafo.existeArista(p, destino)) {
                puente.agregar(p);
            }
        }
        return puente;
    }
}