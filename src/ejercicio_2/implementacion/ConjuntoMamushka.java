package ejercicio_2.implementacion;

import ejercicio_2.interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private int[] elem; // Declaración del arreglo que almacenará los elementos.
    private int indice; // Variable que indica la posición actual para insertar elementos.

    /**
     * Inicializa el conjunto. Define un arreglo de tamaño fijo de 10 elementos y
     * el índice.
     */
    @Override
    public void inicializar() { // Complejidad: constante
        elem = new int[10];
        indice = 0;
    }

    /**
     * Agrega un dato al conjunto. Inserta el dato en la posición indicada por el índice.
     *
     * @param dato El valor a agregar al conjunto.
     */
    @Override
    public void guardar(int dato) { // Complejidad: constante
        elem[indice] = dato;
        indice++;
    }

    /**
     * Elimina una aparición del dato especificado del conjunto.
     * Busca el dato desde el final hacia el principio, y lo reemplaza
     * con el último elemento del conjunto.
     *
     * @param dato El valor a eliminar del conjunto.
     */
    @Override
    public void sacar(int dato) { // Complejidad: lineal
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
     */
    @Override
    public int elegir() { // Complejidad: constante
        return elem[(int) (Math.random() * indice)];
    }

    /**
     * Cuenta cuántas veces aparece un dato específico en el conjunto.
     *
     * @param dato El valor cuya cantidad de apariciones se desea contar.
     * @return La cantidad de veces que el dato aparece en el conjunto.
     */
    @Override
    public int perteneceCant(int dato) { // Complejidad: lineal
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
     */
    @Override
    public boolean estaVacio() { // Complejidad: constante
        return indice == 0;
    }

    /**
     * Imprime todos los elementos del conjunto en la consola.
     */
    public void imprimirConjunto() { // Complejidad: lineal
        for (int i = 0; i < indice; i++) {
            System.out.println(elem[i]);
        }
    }
}
