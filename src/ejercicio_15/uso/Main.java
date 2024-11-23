package ejercicio_15.uso;

import tda.*;
import imple.*;

public class Main {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(2, 3, 20);
        grafo.agregarArista(3, 1, 30);
        grafo.agregarArista(3, 2, 40);

        int grado = gradoVertice(grafo, 3);
        System.out.println("Grado del vertice: " + grado);
    }

    public static int gradoVertice(GrafoTDA grafo, int vertice) {
        int gradoSalida = 0;
        int gradoEntrada = 0;

        // Recorremos los vértices para calcular el grado de salida
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA verticesAux = grafo.vertices();
        while (!verticesAux.conjuntoVacio()) {
            int v = verticesAux.elegir();
            verticesAux.sacar(v);
            if (grafo.existeArista(vertice, v)) {
                gradoSalida++;
            }
        }

        // Recorremos nuevamente los vértices para calcular el grado de entrada
        verticesAux = grafo.vertices();
        while (!verticesAux.conjuntoVacio()) {
            int v = verticesAux.elegir();
            verticesAux.sacar(v);
            if (grafo.existeArista(v, vertice)) {
                gradoEntrada++;
            }
        }
        return gradoSalida - gradoEntrada;
    }
}