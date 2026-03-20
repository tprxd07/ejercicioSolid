package biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        PrestamoService service = new PrestamoService();

        Libro[] libros = new Libro[2];
        libros[0] = new Libro("Dune");
        libros[1] = new LibroReferencia("Diccionario RAE");

        for (Libro libro : libros) {
            service.prestar(libro, "12345678A");
        }

        System.out.println();

        for (Libro libro : libros) {
            if (libro.esPrestable()) {
                System.out.println("Devuelto (" + libro.getTitulo() + "): " + service.devolver(libro));
            } else {
                System.out.println("Libro de referencia (" + libro.getTitulo() + ") permanece en sala.");
            }
        }
    }
}