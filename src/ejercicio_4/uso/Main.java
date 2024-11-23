package ejercicio_4.uso;

import ejercicio_4.implementacion.DiccionarioSimpleMod;
import ejercicio_4.interfaz.DiccionarioSimpleModTDA;

public class Main {
    public static void main(String[] args) {
        probarDiccionarioSimpleMod();
    }

    public static void probarDiccionarioSimpleMod() {
        DiccionarioSimpleModTDA d = new DiccionarioSimpleMod();
        d.inicializarDiccionario();

        d.agregar(3, 25);
        d.agregar(3, 34);
        d.agregar(4, 100);
        d.agregar(1, 50);
        d.agregar(3, 90);

        System.out.println(d.recuperarMod(3));
        System.out.println(d.recuperarMod(1));
        System.out.println(d.recuperarMod(4));
    }
}
