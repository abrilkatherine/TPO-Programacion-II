package ejercicio_11.uso;

public class Main {

    public static void main(String[] args) {

        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultiple();
        diccionarioMultiple.inicializacion();


        ColaTDA queue = valoresUnicos(diccionarioMultiple);
    }

    public static ColaTDA valoresUnicos(DiccionarioMultipleTDA diccionarioMultiple) {

        ColaTDA queue = new Cola();
        queue.inicializarCola();
        ConjuntoTDA conjunto = diccionarioMultiple.obtenerClaves();

        while (!conjunto.conjuntoVacio()) {
            int clave = conjunto.elegir();
            conjunto.sacar(clave);

            int[] valores = diccionarioMultiple.obtenerValores(clave);
            for (int valor : valores) {
                if (!contieneValor(queue, valor)) {
                    queue.acolar(valor);
                }
            }

        }
        return queue;
    }


    private static boolean contieneValor(ColaTDA cola, int valor) {
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        boolean encontrado = false;

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            colaAux.acolar(elemento);
            if (elemento == valor) {
                encontrado = true;
            }
        }

        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return encontrado;
    }
}
