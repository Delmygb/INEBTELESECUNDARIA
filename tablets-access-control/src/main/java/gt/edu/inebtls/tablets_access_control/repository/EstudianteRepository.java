package gt.edu.inebtls.tablets_access_control.repository;

import gt.edu.inebtls.tablets_access_control.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}