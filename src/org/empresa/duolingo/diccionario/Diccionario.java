package org.empresa.duolingo.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.empresa.duolingo.util.Validador;

public class Diccionario {

    private Map<String, Set<String>> diccionario = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void agregarPalabra(String palabra) {

        while (true) {
            if (Validador.validarPalabra(palabra)) {
                System.out.println("Ingrese la palabra que desea agregar:");
                palabra = sc.nextLine();
            } else {
                break;
            }
        }

        String letra = Validador.palabraDividida(palabra);

        if (this.diccionario.containsKey(letra)) {
            Set<String> setPalabras = this.diccionario.get(letra);
            if (setPalabras.contains(palabra)) {
                System.out.println("La palabra ya existe en el diccionario.");
            } else {
                setPalabras.add(palabra);
                System.out.println("Palabra agregada exitosamente.");
            }
        } else {
            Set<String> nuevoSet = new HashSet<>();
            nuevoSet.add(palabra);
            this.diccionario.put(letra, nuevoSet);
            System.out.println("Palabra agregada exitosamente.");
        }

    }

    public void eliminarPalabra() {

        System.out.println("Las palabras que tiene almacenadas son:");
        for (Set<String> palabras : diccionario.values()) {
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        }

        System.out.println("Ingrese la palabra que desea eliminar.");
        String palabraEliminar = sc.nextLine();

        Validador.validarPalabra(palabraEliminar);

        String letra = Validador.palabraDividida(palabraEliminar);

        if (this.diccionario.containsKey(letra)) {
            Set<String> setPalabras = this.diccionario.get(letra);
            if (setPalabras.remove(palabraEliminar)) {
                System.out.println("La palabra " + palabraEliminar +
                        " eliminada exitosamente.");
            } else {
                System.out.println("La palabra " + palabraEliminar +
                        " no está en el diccionario.");
            }
        } else {
            System.out.println("La palabra " + palabraEliminar +
                    " no se encuentra almacenada en el diccionario.");
        }

    }
}
