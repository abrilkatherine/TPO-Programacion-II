package ejercicio_5.implementacion;

import ejercicio_5.interfaz.DiccionarioSimpleTDA;
import imple.ColaPrioridad;
import imple.Conjunto;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private ColaPrioridad elementos;

    /**
     * Inicializa el diccionario simple.
     *
     * Complejidad: Constante.
     */
    @Override
    public void inicializarDiccionario() {
        elementos = new ColaPrioridad();
        elementos.inicializarCola();
    }

    /**
     * Agrega un par clave-valor al diccionario.
     *
     * @param clave La clave asociada al valor.
     * @param valor El valor que se asocia a la clave.
     *
     * Complejidad: Logarítmica.
     */
    @Override
    public void agregar(int clave, int valor) {
        // En la Cola de Prioridad, la prioridad es la clave, y el valor es el valor asociado.
        elementos.acolarPrioridad(valor, clave);
    }

    /**
     * Elimina el elemento con la clave especificada del diccionario.
     *
     * @param clave La clave del elemento a eliminar.
     *
     * Complejidad: Lineal.
     */
    @Override
    public void eliminar(int clave) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();

        // Recorre la cola original y transfiere los elementos que no tienen la clave a eliminar a una cola auxiliar.
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
     *
     * @param clave La clave cuyo valor se desea recuperar.
     * @return El valor asociado a la clave.
     *
     * Complejidad: Lineal.
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
     * @return Un conjunto que contiene todas las claves del diccionario.
     *
     * Complejidad: Lineal.
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
