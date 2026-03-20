package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public void prestar(Libro libro, String dni) {
        if (!libro.esPrestable()) {
            System.out.println("ERROR: El libro '" + libro.getTitulo() + "' solo es para consulta en sala.");
            return;
        }

        if (libro.estaPrestado()) {
            throw new IllegalStateException("Ya estaba prestado");
        }

        libro.prestarA(dni, LocalDate.now().plusDays(14));
        System.out.println("Prestado: " + libro.getTitulo() + " a " + dni);
    }

    public boolean devolver(Libro libro) {
        if (!libro.esPrestable()) return false;
        libro.devolver();
        return !libro.estaPrestado();
    }
}