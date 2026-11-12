package gt.edu.inebtls.tablets_access_control.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gt.edu.inebtls.tablets_access_control.model.Estudiante;
import gt.edu.inebtls.tablets_access_control.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional
    public void guardar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public long contar() {
        return estudianteRepository.count();
    }

    public Estudiante buscarPorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null);
    }

    @Transactional
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}