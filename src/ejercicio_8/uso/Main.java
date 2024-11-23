package ejercicio_8.uso;

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {

        ColaTDA colaOriginal = new Cola(); // Crear una cola original con elementos repetidos
        colaOriginal.inicializarCola();

        // Agregar elementos a la cola original
        colaOriginal.acolar(5);
        colaOriginal.acolar(3);
        colaOriginal.acolar(5);
        colaOriginal.acolar(7);
        colaOriginal.acolar(3);
        colaOriginal.acolar(9);

        System.out.println("Cola original:");
        imprimirCola(colaOriginal);

        // Eliminar elementos repetidos
        ColaTDA colaSinRepetidos = eliminarRepetidos(colaOriginal);

        System.out.println("Cola sin repetidos:");
        imprimirCola(colaSinRepetidos);

        System.out.println("Cola original restaurada:");
        imprimirCola(colaOriginal);
    }

    // Metodo auxiliar para imprimir los elementos de una cola
    public static void imprimirCola(ColaTDA cola) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            System.out.print(elemento + " ");
            cola.desacolar();
            aux.acolar(elemento); // Restaurar en la auxiliar
        }
        System.out.println();

        // Restaurar la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }

    // Metodo eliminarRepetidos
    public static ColaTDA eliminarRepetidos(ColaTDA cola) {
        ConjuntoTDA vistos = new Conjunto(); // conjunto auxiliar para elementos vistos
        ColaTDA resultado = new Cola(); // nueva cola sin repetidos
        ColaTDA aux = new Cola(); // cola auxiliar para restaurar la cola original
        // Inicialización de colas y conjuntos
        vistos.inicializarConjunto();
        resultado.inicializarCola();
        aux.inicializarCola();

        // Búsqueda de elementos no repetidos
        while (!cola.colaVacia()) {
            int elemento = cola.primero(); // Se destruye la cola para procesarla
            cola.desacolar();
            aux.acolar(elemento); // Se guarda el elemento en la cola auxiliar
            if (!vistos.pertenece(elemento)) { // Si el elemento es nuevo se procesa
                vistos.agregar(elemento); // Se agrega el elemento a vistos para evitar repetidos
                resultado.acolar(elemento); // Se agrega el elemento a la nueva cola
            }
        }
        // Restauración de la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
        return resultado;
    }
}