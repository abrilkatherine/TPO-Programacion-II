package ejercicio_5.uso;

import ejercicio_5.implementacion.DiccionarioSimple;
import ejercicio_5.interfaz.DiccionarioSimpleTDA;

public class Main {
    public static void main(String[] args) {
        probarDiccionarioSimple();
    }

    public static void probarDiccionarioSimple() {
        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();
        dic.agregar(3, 40);
        dic.agregar(5, 90);
        System.out.println(dic.recuperar(3));
        System.out.println(dic.recuperar(5));

        dic.eliminar(5);
        System.out.println(dic.recuperar(5));
    }
}
