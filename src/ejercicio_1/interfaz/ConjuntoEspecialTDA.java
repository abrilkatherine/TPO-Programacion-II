package ejercicio_1.interfaz;

public interface ConjuntoEspecialTDA {

    public class Respuesta {
        public boolean error;
        public int rta;
    }

    public void inicializarConjunto(); //Inicializa el conjunto.

    public Respuesta agregar(int valor); //Agrega un valor al conjunto. La Respuesta devuelve el error en true si no se
    // agrega un nuevo valor,

//false si se agregó correctamente.
    public Respuesta sacar(int valor); //Elimina un valor del conjunto. La Respuesta devuelve el error en true si no se
    // realiza una eliminación, false si se eliminó el error.

    public Respuesta elegir(); //Devuelve un valor del conjunto, si el conjunto no tenía valores, devuelve la Respuesta
    // con error en true, en caso contrario la Respuesta contiene el error en false y en rta el valor.

    public boolean pertenece(int valor); //Devuelve un booleano indicando si un valor pertenece al conjunto.

    public boolean conjuntoVacio(); //Devuelve un booleano indicando si el conjunto está vacío o no.
}

