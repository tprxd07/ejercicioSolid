package biblioteca;

import java.time.LocalDate;

public class Libro {
    protected final String titulo;
    protected String prestadoA;
    protected LocalDate fechaDevolucion;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    // Nuevo método para que compruebe si se puede prestar
    public boolean esPrestable() {
        return true;
    }

    public void prestarA(String dni, LocalDate fechaDevolucion) {
        this.prestadoA = dni;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void devolver() {
        this.prestadoA = null;
        this.fechaDevolucion = null;
    }

    public boolean estaPrestado() {
        return prestadoA != null;
    }

    public String getTitulo() {
        return titulo;
    }
}