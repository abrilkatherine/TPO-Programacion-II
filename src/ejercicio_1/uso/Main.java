package ejercicio_1.uso;

import ejercicio_1.implementacion.ConjuntoEspecial;
import ejercicio_1.interfaz.ConjuntoEspecialTDA;

public class Main {
    public static void main(String[] args) {
        probarConjuntoEspecial();
    }

    public static void probarConjuntoEspecial() {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecial();
        conjunto.inicializarConjunto();

        conjunto.agregar(2);
        conjunto.agregar(3);
        conjunto.agregar(4);

        System.out.println(conjunto.elegir().error);
        System.out.println(conjunto.sacar(1).error); //True:no puede sacar algo que no pertenece
        System.out.println(conjunto.sacar(2).error); //False:logra sacarlo
        System.out.println(conjunto.agregar(3).error); //True: ya esta agregado
        System.out.println(conjunto.elegir().rta); //devuelve el entero elegido.
    }
}
