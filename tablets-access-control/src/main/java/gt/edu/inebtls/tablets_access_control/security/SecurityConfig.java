package gt.edu.inebtls.tablets_access_control.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filtros(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(reglas -> reglas
                .requestMatchers("/login", "/estilos.css", "/error").permitAll()
                .requestMatchers("/estudiantes/nuevo", "/estudiantes/*/editar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/estudiantes/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/estudiantes", true))
            .logout(logout -> logout
                .logoutSuccessUrl("/login?salio"))
            .exceptionHandling(errores -> errores
                .accessDeniedPage("/acceso-denegado"));
        return http.build();
    }
}