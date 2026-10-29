package gt.edu.inebtls.tablets_access_control.service;

import org.springframework.stereotype.Service;

@Service
public class BienvenidaService {

    public String obtenerSaludoGenerico() {
        return "¡Bienvenido al Instituto Nacional de Educación Básica en Telesecundaria!";
    }

    public String obtenerSaludoPersonalizado(String nombre) {
        return "Hola, " + nombre + " | ¡Gracias por visitar el instituto.";
    }
}