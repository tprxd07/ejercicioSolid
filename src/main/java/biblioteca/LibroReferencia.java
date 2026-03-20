package biblioteca;

import java.time.LocalDate;

public class LibroReferencia extends Libro {

    public LibroReferencia(String titulo) {
        super(titulo);
    }

    @Override
    public boolean esPrestable() {
        return false; // Notifica que no soporta préstamos externos
    }
    @Override
    public void prestarA(String dni, LocalDate fechaDevolucion) {
        // Se le atribuye el dni de la persona a la que se ha prestado el lirbo
        this.prestadoA = dni;
        this.fechaDevolucion = LocalDate.now();
    }
}