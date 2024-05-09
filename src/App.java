import java.util.Scanner;

import org.empresa.duolingo.diccionario.Diccionario;
import org.empresa.duolingo.util.Menu;

public class App {
    public static void main(String[] args) throws Exception {

        Diccionario diccionario = new Diccionario();
        Scanner sc = new Scanner(System.in);

        boolean entrar = true;

        while (entrar) {

            Menu.mostrarMenuPrincipal();
            System.out.print("Escriba la opcion: ");
            String opcion = sc.next();
            sc.nextLine();

            if (opcion != null) {
                opcion = opcion.trim().toUpperCase();

                switch (opcion) {
                    case "1":

                        System.out.println("Ingrese la palabra que desea almacenar.");
                        String palabra = sc.next();
                        diccionario.agregarPalabra(palabra);

                        break;

                    case "2":

                        diccionario.eliminarPalabra();

                        break;

                    case "3":

                        System.out.println("Ingrese la palabra que desea buscar.");
                        String palabraBuscar = sc.next();
                        diccionario.buscarPalabra(palabraBuscar);

                        break;

                    case "4":

                        diccionario.mostrarInicialesDisponibles();

                        break;

                    case "5":

                        System.out.println("Ingrese la letra, para ver sus palabras almacenada");
                        String letra = sc.next();
                        diccionario.mostrarPalabrasPorInicial(letra);

                        break;

                    case "Q":

                        System.out.println("Adiós");
                        entrar = false;
                        break;

                    default:

                        System.out.println("Selecciona una opción válida.");
                        break;

                }

            } else {

                System.out.println("Ninguna opción seleccionada. Saliendo del programa.");
                entrar = false;

            }
        }

        sc.close();
    }
}
