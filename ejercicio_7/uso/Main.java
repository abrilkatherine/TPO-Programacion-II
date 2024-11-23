/*
El metodo utiliza un conjunto y una pila auxiliares para el procesamiento.
Primero se extraen los datos de la pila para procesar y luego se guardan en una pila auxiliar para
restaurar la original.
Se utiliza el conjunto unicos para almacenar la primera aparicion de un valor, para luego comparar con
los siguientes valores de la pila. Si el elemento ya fue procesado anteriormente, se guarda en el nuevo
conjunto.
*/
public ConjuntoTDA elementosRepetidos(PilaTDA pila) {
    ConjuntoTDA unicos = new ConjuntoTDA(); // conjunto auxiliar para elementos unicos
    ConjuntoTDA repetidos = new ConjuntoTDA(); // conjunto a retornar con elementos repetidos
    PilaTDA aux = new PilaTDA(); // pila auxiliar para restaurar la pila original   
    //inicializacion de pilas y conjuntos
    unicos.inicializarConjunto();
    repetidos.inicializarConjunto();
    aux.inicializarPila();
    //busqueda de elementos repetidos
    while (!pila.pilaVacia()) { 
        int elemento = pila.tope(); //se destruye la pila para procesarla
        pila.desapilar();
        aux.apilar(elemento); //se guarda el dato en la pila auxiliar para reconstruir la pila original
        if (unicos.pertenece(elemento)) {
            repetidos.agregar(elemento); //si el elemento existe se agrega al conjunto de repetidos
        } else {
            unicos.agregar(elemento); //si no es repetido se agrega al conjunto de unicos
        }
    }
    //reconstruccion de pila original
    while (!aux.pilaVacia()) {
        pila.apilar(aux.tope());
        aux.desapilar();
    }
    return repetidos;
}
