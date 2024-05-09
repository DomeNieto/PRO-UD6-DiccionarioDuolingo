package org.empresa.duolingo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public static String palabraDividida(String palabra) {

        String letra = palabra.substring(0, 1);

        return letra;
    }

    public static boolean validarPalabra(String palabra) {

        if (palabra == null || palabra.trim().isEmpty()) {
            System.out.println("La palabra no puede estar vacía.");

            return true;
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z&&[^ñÑ]]+$");
        Matcher matcher = pattern.matcher(palabra);

        if (!matcher.matches()) {
            System.out.println("La palabra contiene un carácter no válido.");

            return true;
        }

        return false;

    }
}
