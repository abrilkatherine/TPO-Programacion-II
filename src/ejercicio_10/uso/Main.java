package ejercicio_10.uso;


import ejercicio_5.implementacion.DiccionarioSimple;

public class Main {

    public static void main(String[] args) {
        PilaTDA pila = new Pila();

        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);

        DiccionarioSimpleTDA diccionarioSimple = transformarPilaEnDiccionarioSimple(pila);
    }


    public static DiccionarioSimpleTDA transformarPilaEnDiccionarioSimple(PilaTDA pila) {

        DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimple();
        diccionarioSimple.inicializacion();

        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();


        /*
        una vez inicializada la pila auxiliar que me va a servir para recontruir la pila original
        y ya inicializado el diccionario simple que me va a servir para contar la cantidad de veces que se repite un elemento


        */

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            pilaAux.apilar(elemento);

            /*
            una vez que recupero el elemento de la pila original
            utilizo el metodo recuperarValor del diccionario para poder recuperar la cantidad de veces que se repite el elemento
        */

            int contador = diccionarioSimple.recuperarValor(elemento);
            if (contador != 0) {
          /*
           en base al resultado de si trajo o no valores contador
           voy a proceder en aumentar +1 la cantidad de coincidencias del elemento en el diccionario
            */

                diccionarioSimple.agregar(elemento, contador + 1);
            } else {

                 /*
                 en caso de que no haya traido valores contador
                 le setteo por default 1
            */
                diccionarioSimple.agregar(elemento, 1);
            }
        }

           /*
              rearmo la pila original con los elementos de la pila auxiliar

            */

        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return diccionarioSimple;
    }


}
