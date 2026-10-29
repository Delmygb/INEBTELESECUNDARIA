package gt.edu.inebtls.tablets_access_control.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import gt.edu.inebtls.tablets_access_control.model.Estudiante;

@Service
public class EstudianteService {
    private final List<Estudiante> estudiantes = new ArrayList<>();
    private Long contadorId = 1L; // Para asignar IDs automáticos

    public void guardar(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(contadorId++);
            estudiantes.add(estudiante);
        } else {
            // Si ya tiene ID, es una actualización (editar)
            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).getId().equals(estudiante.getId())) {
                    estudiantes.set(i, estudiante);
                    break;
                }
            }
        }
    }

    public List<Estudiante> listarTodos() {
        return estudiantes;
    }

    public int contar() {
        return estudiantes.size();
    }

    public Estudiante buscarPorId(Long id) {
        return estudiantes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(Long id) {
        estudiantes.removeIf(e -> e.getId().equals(id));
    }
}