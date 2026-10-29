package gt.edu.inebtls.tablets_access_control.security;

import gt.edu.inebtls.tablets_access_control.model.Usuario;
import gt.edu.inebtls.tablets_access_control.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CargadorUsuarios {

    @Bean
    CommandLineRunner inicializarUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String passwordAdmin = System.getenv("ADMIN_PASSWORD");
            if (passwordAdmin == null) {
                passwordAdmin = "ClaveAdmin123";
            }

            String passwordEntrenador = System.getenv("ENTRENADOR_PASSWORD");
            if (passwordEntrenador == null) {
                passwordEntrenador = "ClaveEntr123";
            }

            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode(passwordAdmin));
                admin.setRol("ADMIN");
                usuarioRepository.save(admin);
            }

            if (usuarioRepository.findByUsername("entrenador").isEmpty()) {
                Usuario entrenador = new Usuario();
                entrenador.setUsername("entrenador");
                entrenador.setPassword(passwordEncoder.encode(passwordEntrenador));
                entrenador.setRol("ENTRENADOR");
                usuarioRepository.save(entrenador);
            }
        };
    }
}