package matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaService {

    private final List<Matricula> matriculas = new ArrayList<>();

    public Matricula crearMatricula(String dni, String curso, double precioBase, boolean bonificacion) {
        // El servicio solo coordina: delega la lógica compleja a la entidad
        Matricula m = new Matricula(dni, curso, precioBase, bonificacion);
        matriculas.add(m);

        System.out.println("[AVISO] Matriculado " + m.getDni() + " en " + m.getCurso() + " por " + m.getPrecioFinal() + "€");
        return m;
    }

    public String exportarResumen() {
        StringBuilder sb = new StringBuilder("RESUMEN MATRÍCULAS\n");
        // El servicio ya no sabe CÓMO se formatea una matrícula, solo pide el dato
        for (Matricula m : matriculas) {
            sb.append(m.toString());
        }
        return sb.toString();
    }
}