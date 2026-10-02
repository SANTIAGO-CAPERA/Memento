package main;

import caretaker.Historial;
import java.util.Scanner;
import originator.Editor;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Editor editor = new Editor();
        Historial historial = new Historial();

        int opcion;

        System.out.println("editor de texto con patron memento");

        do {
            System.out.println();
            System.out.println("contenido actual:");
            System.out.println(editor.getContenido());

            System.out.println();
            System.out.println("1. escribir o modificar contenido");
            System.out.println("2. guardar estado");
            System.out.println("3. restaurar ultimo estado");
            System.out.println("4. mostrar contenido");
            System.out.println("5. mostrar cantidad de estados guardados");
            System.out.println("0. salir");

            System.out.print("seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("escriba el nuevo contenido: ");
                    editor.setContenido(scanner.nextLine());
                    System.out.println("contenido modificado correctamente.");
                    break;

                case 2:
                    historial.guardarEstado(editor.guardar());
                    System.out.println("estado guardado correctamente.");
                    System.out.println(
                        "estados en historial: "
                        + historial.cantidadEstados()
                    );
                    break;

                case 3:
                    if (historial.hayEstados()) {

                        editor.restaurar(historial.obtenerUltimoEstado());

                        System.out.println("estado restaurado correctamente.");
                        System.out.println(
                            "estados restantes: "
                            + historial.cantidadEstados()
                        );

                    } else {

                        System.out.println(
                            "no hay estados guardados para restaurar."
                        );
                    }
                    break;

                case 4:
                    System.out.println("contenido actual:");
                    System.out.println(editor.getContenido());
                    break;

                case 5:
                    System.out.println(
                        "estados guardados: "
                        + historial.cantidadEstados()
                    );
                    break;

                case 0:
                    System.out.println("saliendo del editor.");
                    break;

                default:
                    System.out.println("opcion no valida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
