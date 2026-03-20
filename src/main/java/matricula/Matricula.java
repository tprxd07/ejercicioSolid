package matricula;

import java.time.LocalDate;

public class Matricula {

    private final String dni;
    private final String curso;
    private final LocalDate fecha;
    private final double precioFinal;

    public Matricula(String dni, String curso, double precioBase, boolean bonificacion) {
        // La propia clase se encarga de validar sus datos (SRP)
        validarDni(dni);

        this.dni = dni;
        this.curso = curso;
        this.fecha = LocalDate.now();
        // La lógica de cálculo pertenece al objeto que conoce los datos (SRP)
        this.precioFinal = calcularPrecioFinal(precioBase, bonificacion);
    }

    private void validarDni(String dni) {
        if (dni == null || dni.isBlank() || dni.length() < 7) {
            throw new IllegalArgumentException("DNI inválido");
        }
    }

    private double calcularPrecioFinal(double precioBase, boolean bonificacion) {
        if (precioBase <= 0) throw new IllegalArgumentException("Precio inválido");
        double total = bonificacion ? precioBase * 0.85 : precioBase;
        return total + 12.0; // Gastos de gestión
    }

    public String getDni() { return dni; }
    public String getCurso() { return curso; }
    public LocalDate getFecha() { return fecha; }
    public double getPrecioFinal() { return precioFinal; }

    @Override
    public String toString() {
        return dni + " | " + curso + " | " + fecha + " | " + precioFinal;
    }
}