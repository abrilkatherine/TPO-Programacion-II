package ejercicio_2.implementacion;

import ejercicio_2.interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private int[] elem; // Declaración del arreglo que almacenará los elementos.
    private int indice; // Variable que indica la posición actual para insertar elementos.

    @Override
    public void inicializar() { // Complejidad: Constante
        elem = new int[10]; // Inicializa el arreglo con capacidad para 10 elementos.
        indice = 0; // Inicializa el índice en 0.
    }

    @Override
    public void guardar(int dato) { // Complejidad: Constante
        elem[indice] = dato; // Asigna el dato en la posición indicada por "indice".
        indice++; // Incrementa el índice para la próxima inserción.
    }

    @Override
    public void sacar(int dato) { // Complejidad: Lineal
        // Busca el dato en el arreglo desde el final hacia el principio.
        for (int i = indice - 1; i >= 0; i--) { 
            if (elem[i] == dato) { // Si encuentra el dato..
                elem[i] = elem[indice - 1]; // Reemplaza con el último elemento.
                indice--; // Reduce el tamaño del conjunto.
                return; 
            }
        }
    }

    @Override
    public int elegir() { // Complejidad: Constante
        // Devuelve un elemento aleatorio del arreglo.
        return elem[(int) (Math.random() * indice)];
    }

    @Override
    public int perteneceCant(int dato) { // Complejidad: Lineal
        int cant = 0; // Inicializa el contador.

        for (int i = 0; i < indice; i++) { // Recorre todos los elementos.
            if (elem[i] == dato) // Si el elemento coincide con el dato...
                cant++; // Incrementa el contador.
        }
        return cant; // Devuelve la cantidad de coincidencias.
    }

    @Override
    public boolean estaVacio() { // Complejidad: Constante
        // Devuelve si el índice es igual a 0, lo que indica que no hay elementos.
        return indice == 0;
    }

    public void p() { // Complejidad: Lineal
        // Imprime todos los elementos del conjunto.
        for (int i = 0; i < indice; i++) {
            System.out.println(elem[i]);
        }
    }
}
