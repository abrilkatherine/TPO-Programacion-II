package ejercicio_1.implementacion;

import ejercicio_1.interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    /** Resolución adoptada: implementación estática */

    private int[] conjunto; //almacena los elementos del conjunto.
    private int cant; //indica la cantidad actual de elementos en el conjunto.
    private Respuesta resp; // objeto para manejar respuestas con posibles errores.

    /**
     * Inicializa el conjunto como un arreglo de tamaño fijo, el contador y el objeto respuesta.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public void inicializarConjunto() {
        conjunto = new int[100];
        cant = 0;
        resp = new Respuesta(); // Inicializa el objeto de respuesta.
    }

    /**
     * Agrega un valor al conjunto si no pertenece a él.
     *
     * @param valor El valor que se desea agregar.
     * @return Un objeto {@link Respuesta} indicando éxito o error (si el valor ya existía).
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public Respuesta agregar(int valor) {
        if (!pertenece(valor)) {
            resp.error = false; // Indica que no hubo error.
            conjunto[cant] = valor; // Añade el valor al arreglo.
            cant++; // Incrementa la cantidad de elementos.
        } else {
            resp.error = true; // Indica que el valor ya existía en el conjunto.
        }
        return resp;
    }

    /**
     * Elimina un valor del conjunto si está presente.
     *
     * @param valor El valor que se desea eliminar.
     * @return Un objeto {@link Respuesta} indicando éxito o error (si el valor no estaba en el conjunto).
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public Respuesta sacar(int valor) {
        int i = 0;

        while (i < cant && conjunto[i] != valor) {
            i++;
        }
        if (i < cant) {
            resp.error = false; // Indica que no hubo error.
            conjunto[i] = conjunto[cant - 1]; // Sustituye el valor eliminado con el último elemento (O(1)).
            cant--; // Decrementa la cantidad de elementos.
        } else {
            resp.error = true; // Indica que el valor no estaba en el conjunto.
        }
        return resp;
    }

    /**
     * Selecciona un elemento aleatorio del conjunto si no está vacío.
     *
     * @return Un objeto {@link Respuesta} con el elemento elegido o indicando error si el conjunto está vacío.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public Respuesta elegir() {
        if (!conjuntoVacio()) {
            resp.error = false; // Indica que no hubo error.
            int max = cant - 1;
            int min = 0;
            int pos = (int) (Math.random() * (max - min + 1) + min); // Genera una posición aleatoria entre 0 y (cant-1).
            resp.rta = conjunto[pos]; // Asigna el elemento elegido a la respuesta.
        } else {
            resp.error = true; // Indica que el conjunto está vacío.
        }
        return resp;
    }

    /**
     * Verifica si un valor pertenece al conjunto.
     *
     * @param valor El valor que se desea verificar.
     * @return {@code true} si el valor pertenece al conjunto, {@code false} en caso contrario.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public boolean pertenece(int valor) {
        int i = 0;
        while (i < cant && conjunto[i] != valor) {
            i++;
        }
        return i < cant;
    }

    /**
     * Verifica si el conjunto está vacío.
     *
     * @return {@code true} si no hay elementos en el conjunto, {@code false} en caso contrario.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public boolean conjuntoVacio() {
        return cant == 0;
    }
}
