/*
El metodo utiliza un conjunto, una cola y una pila auxiliares para el procesamiento.
Primero se extraen los datos de la pila para procesar, se almacenan en un conjunto auxiliar
y luego se guardan en una pila auxiliar para restaurar la original.
Utilizando el conjunto auxiliar, se verifica si los elementos de la cola pertenecen al conjunto, en caso
de pertenecer, se guardan en el conjunto comunes.
*/
public ConjuntoTDA elementosComunes(PilaTDA pila, ColaTDA cola) {
    ConjuntoTDA elementosPila = new ConjuntoTDA(); // conjunto auxiliar para almacenar los elementos de la pila
    ConjuntoTDA comunes = new ConjuntoTDA(); // conjunto para elementos comunes
    PilaTDA auxPila = new PilaTDA(); // pila auxiliar para restaurar la pila original
    ColaTDA auxCola = new ColaTDA(); // cola auxiliar para restaurar la cola original
    //inicializacion de colas y conjuntos 
    elementosPila.inicializarConjunto();
    comunes.inicializarConjunto();
    auxPila.inicializarPila();
    auxCola.inicializarCola();
    //traspasar elementos de la pila al conjunto elementosPila
    while (!pila.pilaVacia()) {
        int elemento = pila.tope(); //se destruye la pila para procesarla
        pila.desapilar();
        auxPila.apilar(elemento); //se apilan los elementos para luego restaurar la pila original
        elementosPila.agregar(elemento); //se agregan los elementos al conjunto auxiliar de comparacion
    }
    //comparar elementos comunes con la cola
    while (!cola.colaVacia()) {
        int elemento = cola.primero(); //se destruye la cola para procesarla
        cola.desacolar(); 
        auxCola.acolar(elemento); //se acolan los elementos para luego restaurar la cola original
        if (elementosPila.pertenece(elemento)) { //se compara si el elemento existe
            comunes.agregar(elemento); //se agrega el elemento al conjunto comunes
        }
    }
    //restauracion de la pila original
    while (!auxPila.pilaVacia()) {
        pila.apilar(auxPila.tope());
        auxPila.desapilar();
    }
    //restauracion de la cola original
    while (!auxCola.colaVacia()) {
        cola.acolar(auxCola.primero());
        auxCola.desacolar();
    }
    return comunes;
}
