package gt.edu.inebtls.tablets_access_control.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import gt.edu.inebtls.tablets_access_control.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}