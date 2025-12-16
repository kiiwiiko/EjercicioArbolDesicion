import Clases.Genero;
import Clases.Publico;
import Clases.TipoContenido;

import java.util.Scanner;

public class ArbolDecisionBiblioteca {

    public Libro registrarYClasificar(Scanner sc) {
        System.out.print("Título del libro: ");
        String titulo = sc.nextLine().trim();

        // Los estudiantes deben completar estas 3 decisiones (árboles)
        TipoContenido tipo = decidirTipoContenido(sc);
        Genero genero = decidirGenero(sc);
        Publico publico = decidirPublico(sc);

        return new Libro(titulo, tipo, genero, publico);
    }

    // ===== Árbol 1: Tipo de contenido =====
    private TipoContenido decidirTipoContenido(Scanner sc) {
        // TODO: Implementar el árbol:
        // 1) ¿Es educativo? -> EDUCATIVO
        // 2) Si no: ¿Es de ficción? -> FICCION
        // 3) Si no: -> NO_FICCION

        // Pista: usa preguntarSiNo(sc, "pregunta...")
        return null; // TODO: reemplazar
    }

    // ===== Árbol 2: Género =====
    private Genero decidirGenero(Scanner sc) {
        // TODO: Implementar el árbol:
        // 1) ¿Tiene elementos fantásticos? -> FANTASIA
        // 2) Si no: ¿Basado en hechos reales? -> HISTORIA_BIOGRAFIA
        // 3) Si no: ¿Explica ciencia/tecnología? -> CIENCIA_TECNOLOGIA
        // 4) Si no: -> LITERATURA_GENERAL

        return null; // TODO: reemplazar
    }

    // ===== Árbol 3: Público =====
    private Publico decidirPublico(Scanner sc) {
        // TODO: Implementar el árbol:
        // 1) ¿Dirigido a niños? -> INFANTIL
        // 2) Si no: ¿Dirigido a jóvenes? -> JUVENIL
        // 3) Si no: -> ADULTO

        return null; // TODO: reemplazar
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