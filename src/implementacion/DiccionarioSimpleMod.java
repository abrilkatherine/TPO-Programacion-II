package implementacion;

import imple.Conjunto;
import interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

import java.util.NoSuchElementException;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    // Nodo interno para representar cada entrada del diccionario
    private class Nodo {
        int clave; // la clave
        int valor; // el valor
        int modificacion; // // Cantidad de veces que el valor ha sido modificado
        Nodo sigClave; // Referencia a la siguiente clave
    }

    private Nodo origen;  // Referencia al primer nodo de la lista (origen)

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        Nodo nuevo = buscarNodoPorClave(clave);

        if (nuevo == null) { // La clave no existe; se crea un nuevo nodo con modificacion = 0
            nuevo = new Nodo();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.modificacion = 0;
            nuevo.sigClave = origen;
            origen = nuevo;
        } else { // La clave existe, se actualiza el valor y se incrementa el factor de modificaciones
            nuevo.valor = valor;
            nuevo.modificacion++;
        }
    }

    /**
     * Busca un nodo por su clave.
     *
     * @param clave La clave a buscar.
     * @return El nodo correspondiente a la clave, o null si no se encuentra.
     */

    private Nodo buscarNodoPorClave(int clave) { // Metodo aux
        Nodo aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }

    /**
     * Obtiene un nodo por su clave, lanzando una excepción si no existe.
     *
     * @param clave La clave a buscar.
     * @return El nodo correspondiente a la clave.
     * @throws NoSuchElementException Si la clave no se encuentra.
     */

    private Nodo obtenerNodoPorClave(int clave) { // Metodo aux
        Nodo nodo = buscarNodoPorClave(clave);
        if (nodo == null) {
            throw new NoSuchElementException("Clave no encontrada: " + clave);
        }
        return nodo;
    }

    @Override
    public void eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) { // Es el primer nodo
                origen = origen.sigClave;
            } else { // Es otro nodo
                Nodo aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    @Override
    public int recuperar(int clave) {
        Nodo nodo = obtenerNodoPorClave(clave);
        return nodo.valor;
    }

    @Override
    public int recuperarMod(int clave) {
        Nodo nodo = obtenerNodoPorClave(clave);
        return nodo.modificacion;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        Nodo aux = origen;
        while (aux != null) {
            conjunto.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return conjunto;
    }
}