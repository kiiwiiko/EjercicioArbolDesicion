import Clases.Genero;
import Clases.Publico;
import Clases.TipoContenido;

import java.util.ArrayList;
import java.util.List;

public class RegistroBiblioteca {
    private final List<Libro> libros = new ArrayList<>();

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Libro> filtrarPorTipo(TipoContenido tipo) {
        List<Libro> res = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTipoContenido() == tipo) res.add(l);
        }
        return res;
    }

    public List<Libro> filtrarPorGenero(Genero genero) {
        List<Libro> res = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getGenero() == genero) res.add(l);
        }
        return res;
    }

    public List<Libro> filtrarPorPublico(Publico publico) {
        List<Libro> res = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getPublico() == publico) res.add(l);
        }
        return res;
    }
}