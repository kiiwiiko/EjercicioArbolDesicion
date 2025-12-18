import Clases.Genero;
import Clases.Publico;
import Clases.TipoContenido;

import java.util.Scanner;

public class ArbolDecisionBiblioteca {

    public Libro registrarYClasificar(Scanner sc) {
        System.out.print("Título del libro: ");
        String titulo = sc.nextLine().trim();


        TipoContenido tipo = decidirTipoContenido(sc);
        Genero genero = decidirGenero(sc);
        Publico publico = decidirPublico(sc);

        return new Libro(titulo, tipo, genero, publico);
    }

    // ===== Árbol 1: Tipo de contenido =====
    private TipoContenido decidirTipoContenido(Scanner sc) {
        return null;
    }

    // ===== Árbol 2: Género =====
    private Genero decidirGenero(Scanner sc) {
        return null;
    }

    // ===== Árbol 3: Público =====
    private Publico decidirPublico(Scanner sc) {
        return null;
    }

    //Valida si el ususario ingresa si o no
    private boolean preguntarSiNo(Scanner sc, String pregunta) {
        String r;
        do {
            System.out.print(pregunta);
            r = sc.nextLine().trim().toLowerCase();
        } while (!r.equals("si") && !r.equals("no"));
        return r.equals("si");
    }
}