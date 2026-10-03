package gt.edu.inebtls.tablets_access_control.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import gt.edu.inebtls.tablets_access_control.model.Estudiante;

@Service
public class EstudianteService {
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public void guardar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> listarTodos() {
        return estudiantes;
    }

    public int contar() {
        return estudiantes.size();
    }

    public Estudiante buscarPorNumero(int numero) {
        if (numero < 1 || numero > estudiantes.size()) {
            return null;
        }
        return estudiantes.get(numero - 1);
    }
}