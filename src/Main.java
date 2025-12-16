import Clases.Genero;
import Clases.Publico;
import Clases.TipoContenido;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistroBiblioteca registro = new RegistroBiblioteca();
        ArbolDecisionBiblioteca arbol = new ArbolDecisionBiblioteca();

        int op;
        do {
            System.out.println("\n=== MENÚ - BIBLIOTECA (ÁRBOL DE DECISIÓN) ===");
            System.out.println("1) Agregar libro");
            System.out.println("2) Ver TODOS");
            System.out.println("3) Ver SOLO por TIPO DE CONTENIDO");
            System.out.println("4) Ver SOLO por GÉNERO");
            System.out.println("5) Ver SOLO por PÚBLICO");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            op = leerEntero(sc);

            switch (op) {
                case 1 -> {
                    try {
                        Libro libro = arbol.registrarYClasificar(sc);
                        registro.agregar(libro);
                        System.out.println("Guardado: " + libro);
                    } catch (Exception ex) {
                        System.out.println("No se pudo registrar: " + ex.getMessage());
                    }
                }
                case 2 -> mostrarLista("TODOS", registro.getLibros());
                case 3 -> menuTipo(sc, registro);
                case 4 -> menuGenero(sc, registro);
                case 5 -> menuPublico(sc, registro);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);

        sc.close();
    }

    // -------- Submenús --------

    private static void menuTipo(Scanner sc, RegistroBiblioteca registro) {
        System.out.println("\n--- Filtrar por TIPO ---");
        System.out.println("1) EDUCATIVO");
        System.out.println("2) FICCION");
        System.out.println("3) NO_FICCION");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        TipoContenido t = switch (op) {
            case 1 -> TipoContenido.EDUCATIVO;
            case 2 -> TipoContenido.FICCION;
            case 3 -> TipoContenido.NO_FICCION;
            default -> null;
        };

        if (t == null) {
            System.out.println("Opción inválida.");
            return;
        }

        mostrarLista("TIPO = " + t, registro.filtrarPorTipo(t));
    }

    private static void menuGenero(Scanner sc, RegistroBiblioteca registro) {
        System.out.println("\n--- Filtrar por GÉNERO ---");
        System.out.println("1) FANTASIA");
        System.out.println("2) HISTORIA_BIOGRAFIA");
        System.out.println("3) CIENCIA_TECNOLOGIA");
        System.out.println("4) LITERATURA_GENERAL");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        Genero g = switch (op) {
            case 1 -> Genero.FANTASIA;
            case 2 -> Genero.HISTORIA_BIOGRAFIA;
            case 3 -> Genero.CIENCIA_TECNOLOGIA;
            case 4 -> Genero.LITERATURA_GENERAL;
            default -> null;
        };

        if (g == null) {
            System.out.println("Opción inválida.");
            return;
        }

        mostrarLista("GÉNERO = " + g, registro.filtrarPorGenero(g));
    }

    private static void menuPublico(Scanner sc, RegistroBiblioteca registro) {
        System.out.println("\n--- Filtrar por PÚBLICO ---");
        System.out.println("1) INFANTIL");
        System.out.println("2) JUVENIL");
        System.out.println("3) ADULTO");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        Publico p = switch (op) {
            case 1 -> Publico.INFANTIL;
            case 2 -> Publico.JUVENIL;
            case 3 -> Publico.ADULTO;
            default -> null;
        };

        if (p == null) {
            System.out.println("Opción inválida.");
            return;
        }

        mostrarLista("PÚBLICO = " + p, registro.filtrarPorPublico(p));
    }

    // -------- Helpers --------

    private static void mostrarLista(String titulo, List<Libro> lista) {
        System.out.println("\n=== " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("(No hay registros)");
            return;
        }
        int i = 1;
        for (Libro l : lista) {
            System.out.println(i + ") " + l); // usa toString()
            i++;
        }
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}