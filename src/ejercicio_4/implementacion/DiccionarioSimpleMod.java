package ejercicio_4.implementacion;

import ejercicio_4.interfaz.DiccionarioSimpleModTDA;
import imple.Conjunto;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    /** Resolución adoptada: implementación estática */

    // Clase interna que representa un elemento del diccionario
    private class Elemento {
        int clave;
        int valor;
        int factorMod; // Contador de modificaciones del valor
    }

    private Elemento[] elementos;  // Arreglo que almacena los elementos
    private int cant;              // Cantidad actual de elementos en el diccionario

    /**
     * Inicializa el diccionario dejándolo listo para su uso.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public void inicializarDiccionario() {
        cant = 0;
        elementos = new Elemento[10];
    }

    /**
     * Agrega un par clave-valor al diccionario. Si la clave ya existe, actualiza el valor y
     * incrementa el contador de modificaciones. Si es una nueva clave, la agrega con un factor
     * de modificación de 0.
     *
     * @param clave Clave del elemento a agregar o modificar.
     * @param valor Valor asociado a la clave.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public void agregar(int clave, int valor) {
        int pos = this.clave2Indice(clave);

        if (pos == -1) {
            // La clave no existe, se agrega un nuevo elemento
            elementos[cant] = new Elemento();
            elementos[cant].clave = clave;
            elementos[cant].factorMod = 0; // Factor de modificación inicial es 0
            elementos[cant].valor = valor;
            cant++;
        } else {
            // La clave existe, se actualiza el valor y se incrementa el factor de modificación
            elementos[pos].valor = valor;
            elementos[pos].factorMod += 1; // Incrementa el contador de modificaciones
        }
    }

    /**
     * Elimina un elemento del diccionario basado en su clave.
     *
     * @param clave Clave del elemento a eliminar.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public void eliminar(int clave) {
        int pos = clave2Indice(clave);
        if (pos != -1) {
            // Reemplaza el elemento a eliminar con el último y disminuye la cantidad
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    /**
     * Recupera el valor asociado a una clave específica.
     *
     * @param clave Clave del elemento cuyo valor se desea recuperar.
     * @return Valor asociado a la clave.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public int recuperar(int clave) {
        int pos = clave2Indice(clave);
        return elementos[pos].valor;
    }

    /**
     * Recupera el factor de modificaciones (cantidad de veces que el valor ha sido modificado)
     * asociado a una clave específica.
     *
     * @param clave Clave del elemento cuyo factor de modificación se desea recuperar.
     * @return Factor de modificaciones de la clave.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public int recuperarMod(int clave) {
        int pos = clave2Indice(clave);
        return elementos[pos].factorMod;
    }

    /**
     * Devuelve un conjunto con todas las claves almacenadas en el diccionario.
     *
     * @return Conjunto de claves presentes en el diccionario.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public ConjuntoTDA claves() {
        int i = cant - 1;
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();

        while (i >= 0) {
            claves.agregar(elementos[i].clave);
            i--;
        }
        return claves;
    }

    /**
     * Metodo privado que busca el índice de una clave en el arreglo de elementos.
     *
     * @param clave Clave a buscar en el diccionario.
     * @return Índice del elemento si se encuentra; -1 si no existe.
     *
     * @implNote Complejidad: Lineal.
     */
    private int clave2Indice(int clave) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }
}
