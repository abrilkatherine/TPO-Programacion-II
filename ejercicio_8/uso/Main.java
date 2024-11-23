/*
El metodo utiliza un conjunto y una cola auxiliares para el procesamiento.
Primero se extraen los datos de la cola para procesar y se guardan en una cola auxiliar para luego 
restaurar la original.
De forma similar al ejercicio 7, se utiliza un conjunto para guardar la primera aparicion de un valor,
para utilizarlo como comparacion. Si el elemento no pertenece al conjunto auxiliar, se acola y se agrega
al conjunto de elementos vistos.
*/
public ColaTDA eliminarRepetidos(ColaTDA cola) {
    ConjuntoTDA vistos = new ConjuntoTDA(); // conjunto auxiliar para elementos vistos
    ColaTDA resultado = new ColaTDA(); // nueva cola sin repetidos
    ColaTDA aux = new ColaTDA(); // cola auxiliar para restaurar la cola original
    //inicializacion de colas y conjuntos
    vistos.inicializarConjunto();
    resultado.inicializarCola();
    aux.inicializarCola();
    //busqueda de elementos no repetidos
    while (!cola.colaVacia()) {
        int elemento = cola.primero(); //se destruye la cola para procesarla
        cola.desacolar();
        aux.acolar(elemento); //se guarda el elemento en la cola auxiliar
        if (!vistos.pertenece(elemento)) {  //si el elemento es nuevo se procesa
            vistos.agregar(elemento); //se agrega el elemento a vistos para evitar repetidos
            resultado.acolar(elemento); //se agrega el elemento a la nueva cola
        }
    }
    //restauracion de la cola original 
    while (!aux.colaVacia()) {
        cola.acolar(aux.primero());
        aux.desacolar();
    }
    return resultado;
}
