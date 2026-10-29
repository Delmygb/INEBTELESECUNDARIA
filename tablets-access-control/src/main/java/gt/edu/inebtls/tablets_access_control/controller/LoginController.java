package gt.edu.inebtls.tablets_access_control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Busca una plantilla llamada login.html
    }
}