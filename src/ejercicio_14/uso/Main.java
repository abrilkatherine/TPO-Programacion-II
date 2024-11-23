package ejercicio_14.uso;

import imple.Conjunto;
import imple.Grafo;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

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

    public static ConjuntoTDA puente(GrafoTDA g, int o, int d) { // Complejidad: Exponencial
        ConjuntoTDA puente = new Conjunto();
        puente.inicializarConjunto();
        ConjuntoTDA vertices = g.vertices();

        // Verificar todos los posibles vértices p en el grafo
        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            // Si p no es o ni d, verificar si p es puente entre o y d
            if (p != o && p != d && g.existeArista(o, p) && g.existeArista(p, d)) {
                puente.agregar(p);
            }
        }
        return puente;
    }
}