package ejercicio_3.uso;

import tda.PilaTDA;
import imple.Pila;
import ejercicio_3.interfaz.MultiPilaTDA;
import ejercicio_3.implementacion.MultiPila;

public class Main {
	public static void main(String[] args) {
		probarPila();
	}

	public static void probarPila() {
		// Creación de la primera pila
		PilaTDA pilaNormal = new Pila();
		pilaNormal.inicializarPila();
		pilaNormal.apilar(2);
		pilaNormal.apilar(5);
		System.out.println("\nPrimera pila creada y cargada: [5, 2]");

		// Creación de la segunda pila
		PilaTDA valores = new Pila();
		valores.inicializarPila();
		valores.apilar(100);
		valores.apilar(80);
		valores.apilar(95);
		System.out.println("Segunda pila creada y cargada: [95, 80, 100]");

		// Creación de la MultiPila y apilado de ambas pilas
		MultiPilaTDA multiPila = new MultiPila();
		multiPila.inicializarMultiPila();
		multiPila.apilar(pilaNormal);
		multiPila.apilar(valores);
		System.out.println("\nAmbas pilas apiladas en la MultiPila.");

		// Obtener los primeros 4 elementos del tope de la MultiPila
		int cantidadTope = 4;
		PilaTDA pilaTope = multiPila.tope(cantidadTope);
		System.out.println("\nExtrayendo los primeros " + cantidadTope + " elementos de la MultiPila:");

		while (!pilaTope.pilaVacia()) {
			System.out.println("  - " + pilaTope.tope());
			pilaTope.desapilar();
		}
	}
}
