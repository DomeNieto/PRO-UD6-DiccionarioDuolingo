package org.empresa.duolingo.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.empresa.duolingo.util.Validador;

public class Diccionario {

    private Map<String, Set<String>> diccionario = new HashMap<>();

    public void agregarPalabra(String palabra) {

        Scanner sc = new Scanner(System.in);

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

        sc.close();
    }

}
