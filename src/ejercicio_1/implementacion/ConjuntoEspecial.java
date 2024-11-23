package ejercicio_1.implementacion;


import ejercicio_1.interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private int[] conjunto; //almacena los elementos del conjunto.
    private int cant; //indica la cantidad actual de elementos en el conjunto.
    private Respuesta resp; // objeto para manejar respuestas con posibles errores.

    @Override
    public void inicializarConjunto() { // Complejidad:constante
        // Inicializa el conjunto como un arreglo de tamaño fijo y el contador en 0.
        conjunto = new int[100];
        cant = 0;
        resp = new Respuesta(); // Inicializa el objeto de respuesta.
    }

    @Override
    public Respuesta agregar(int valor) { // Complejidad:lineal
        // Agrega un valor al conjunto si no pertenece a él.
        if (!pertenece(valor)) {
            resp.error = false; // Indica que no hubo error.
            conjunto[cant] = valor; // Añade el valor al arreglo.
            cant++; // Incrementa la cantidad de elementos.
        } else {
            resp.error = true; // Indica que el valor ya existía en el conjunto.
        }
        return resp; // Devuelve el objeto de respuesta.
    }

    @Override
    public Respuesta sacar(int valor) { // Complejidad:lineal
        // Elimina un valor del conjunto si está presente.
        int i = 0;

        while (i < cant && conjunto[i] != valor) { // Búsqueda lineal.
            i++;
        }
        if (i < cant) {
            resp.error = false; // Indica que no hubo error.
            conjunto[i] = conjunto[cant - 1]; // Sustituye el valor eliminado con el último elemento (O(1)).
            cant--; // Decrementa la cantidad de elementos.
        } else {
            resp.error = true; // Indica que el valor no estaba en el conjunto.
        }
        return resp; // Devuelve el objeto de respuesta.
    }

    @Override
    public Respuesta elegir() { // Complejidad: constante
        // Selecciona un elemento aleatorio del conjunto, si no está vacío.
        if (!conjuntoVacio()) {
            resp.error = false; // Indica que no hubo error.
            int max = cant - 1;
            int min = 0;
            // Genera una posición aleatoria entre 0 y (cant-1).
            int pos = (int) (Math.random() * (max - min + 1) + min);
            resp.rta = conjunto[pos]; // Asigna el elemento elegido a la respuesta.
        } else {
            resp.error = true; // Indica que el conjunto está vacío.
        }
        return resp; // Devuelve el objeto de respuesta.
    }

    @Override
    public boolean pertenece(int valor) { // Complejidad:lineal
        // Verifica si un valor pertenece al conjunto.
        int i = 0;
        while (i < cant && conjunto[i] != valor) { // Búsqueda lineal.
            i++;
        }
        return i < cant; // Devuelve true si el valor está en el conjunto.
    }

    @Override
    public boolean conjuntoVacio() { // Complejidad:constante
        // Verifica si el conjunto está vacío.
        return cant == 0; // Devuelve true si no hay elementos en el conjunto.
    }
}
