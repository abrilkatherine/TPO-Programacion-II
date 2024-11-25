package ejercicio_2.implementacion;

import ejercicio_2.interfaz.ConjuntoMamushkaTDA;

/** Resolución adoptada: implementación estática */

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private int[] elem; // Declaración del arreglo que almacenará los elementos.
    private int indice; // Variable que indica la posición actual para insertar elementos.

    /**
     * Inicializa el conjunto. Define un arreglo de tamaño fijo de 10 elementos y
     * el índice.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public void inicializar() {
        elem = new int[10];
        indice = 0;
    }

    /**
     * Agrega un dato al conjunto. Inserta el dato en la posición indicada por el índice.
     *
     * @param dato El valor a agregar al conjunto.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public void guardar(int dato) {
        elem[indice] = dato;
        indice++;
    }

    /**
     * Elimina una aparición del dato especificado del conjunto.
     * Busca el dato desde el final hacia el principio, y lo reemplaza
     * con el último elemento del conjunto.
     *
     * @param dato El valor a eliminar del conjunto.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public void sacar(int dato) {
        for (int i = indice - 1; i >= 0; i--) { 
            if (elem[i] == dato) {
                elem[i] = elem[indice - 1];
                indice--; // Reduce el tamaño del conjunto.
                return; 
            }
        }
    }

    /**
     * Selecciona un elemento aleatorio del conjunto.
     *
     * @return Un elemento random del conjunto.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public int elegir() {
        return elem[(int) (Math.random() * indice)];
    }

    /**
     * Cuenta cuántas veces aparece un dato específico en el conjunto.
     *
     * @param dato El valor cuya cantidad de apariciones se desea contar.
     * @return La cantidad de veces que el dato aparece en el conjunto.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public int perteneceCant(int dato) {
        int cant = 0;

        for (int i = 0; i < indice; i++) {
            if (elem[i] == dato)
                cant++;
        }
        return cant;
    }

    /**
     * Verifica si el conjunto está vacío.
     *
     * @return {@code true} si el conjunto está vacío, {@code false} en caso contrario.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public boolean estaVacio() {
        return indice == 0;
    }

    /**
     * Imprime todos los elementos del conjunto en la consola.
     *
     * @implNote Complejidad: Lineal.
     */
    public void imprimirConjunto() {
        for (int i = 0; i < indice; i++) {
            System.out.println(elem[i]);
        }
    }
}
