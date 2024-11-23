package ejercicio_5.interfaz;

import tda.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
    void inicializarDiccionario();
    void agregar(int clave, int valor); //diccionario inicializado
    void eliminar(int clave); //diccionario inicializado
    int recuperar(int clave); //diccionario inicializado y	clave existente
    ConjuntoTDA claves(); //diccionario inicializado
}
