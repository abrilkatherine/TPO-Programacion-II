package ejercicio_5.implementacion;

import ejercicio_5.interfaz.DiccionarioSimpleTDA;
import imple.ColaPrioridad;
import imple.Conjunto;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    /** Resolución adoptada: implementación a partir de ColaPrioridadTDA. */

    private ColaPrioridad elementos;

    /**
     * Inicializa el diccionario simple dejándolo listo para su uso.
     *
     * @implNote Complejidad: Constante.
     */
    @Override
    public void inicializarDiccionario() {
        elementos = new ColaPrioridad();
        elementos.inicializarCola();
    }

    /**
     * Agrega un par clave-valor al diccionario. Si la clave ya existe, agrega
     * un nuevo valor con la misma clave.
     *
     * @param clave La clave (prioridad) asociada al valor.
     * @param valor El valor que se asocia a la clave.
     *
     * @implNote Complejidad: lineal.
     */
    @Override
    public void agregar(int clave, int valor) {
        elementos.acolarPrioridad(valor, clave);
    }

    /**
     * Elimina el elemento asociado a la clave especificada en el diccionario.
     * Si la clave no existe, no realiza cambios.
     *
     * @param clave La clave del elemento a eliminar.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public void eliminar(int clave) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();

        // Recorre la cola original y transfiere los elementos no coincidentes a una cola auxiliar.
        while (!elementos.colaVacia()) {
            int prioridad = elementos.prioridad();
            if (prioridad != clave) {
                colaAux.acolarPrioridad(elementos.primero(), prioridad);
            }
            elementos.desacolar();
        }

        // Restaura los elementos desde la cola auxiliar a la cola original.
        while (!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
    }

    /**
     * Recupera el valor asociado a la clave especificada en el diccionario.
     * Si hay múltiples valores asociados a la clave, devuelve uno de ellos.
     *
     * @param clave La clave cuyo valor se desea recuperar.
     * @return El valor asociado a la clave. Si la clave no existe, devuelve 0.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public int recuperar(int clave) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        int elemento = 0;

        // Recorre la cola de prioridad buscando la clave.
        while (!elementos.colaVacia()) {
            int valor = elementos.primero();
            int prioridad = elementos.prioridad();
            if (clave == prioridad) {
                elemento = valor;
            }
            colaAux.acolarPrioridad(valor, prioridad);
            elementos.desacolar();
        }

        // Restaura los elementos desde la cola auxiliar a la cola original.
        while (!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        return elemento;
    }

    /**
     * Devuelve un conjunto con todas las claves presentes en el diccionario.
     *
     * @return Un conjunto que contiene todas las claves del diccionario. Si el
     * diccionario está vacío, devuelve un conjunto vacío.
     *
     * @implNote Complejidad: Lineal.
     */
    @Override
    public ConjuntoTDA claves() {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();

        // Recorre la cola de prioridad, agrega las claves al conjunto y almacena los elementos en una cola auxiliar.
        while (!elementos.colaVacia()) {
            int prioridad = elementos.prioridad();
            conj.agregar(prioridad);
            colaAux.acolarPrioridad(elementos.primero(), prioridad);
            elementos.desacolar();
        }

        // Restaura los elementos desde la cola auxiliar a la cola original.
        while (!colaAux.colaVacia()) {
            elementos.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        return conj;
    }
}
