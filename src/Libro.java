import Clases.Genero;
import Clases.Publico;
import Clases.TipoContenido;

public class Libro {

    private final String titulo;
    private final TipoContenido tipoContenido;
    private final Genero genero;
    private final Publico publico;

    public Libro(String titulo,
                 TipoContenido tipoContenido,
                 Genero genero,
                 Publico publico) {

        this.titulo = titulo;
        this.tipoContenido = tipoContenido;
        this.genero = genero;
        this.publico = publico;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public Genero getGenero() {
        return genero;
    }

    public Publico getPublico() {
        return publico;
    }

    @Override
    public String toString() {
        // Pensado para mostrarse en un JList
        return titulo + "  [" + tipoContenido + " | " + genero + " | " + publico + "]";
    }
}