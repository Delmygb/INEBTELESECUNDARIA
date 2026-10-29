package gt.edu.inebtls.tablets_access_control.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import gt.edu.inebtls.tablets_access_control.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByNombreContainingIgnoreCase(String texto);
    List<Estudiante> findByTienetabletaTrue();
}