package gt.edu.inebtls.tablets_access_control.controller;

import gt.edu.inebtls.tablets_access_control.service.BienvenidaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaController {

    private final BienvenidaService bienvenidaService;

    public BienvenidaController(BienvenidaService bienvenidaService) {
        this.bienvenidaService = bienvenidaService;
    }

    @GetMapping("/api/saludo")
    public String saludo() {
        return bienvenidaService.obtenerSaludoGenerico();
    }

    @GetMapping("/api/bienvenida")
    public String bienvenida(@RequestParam(defaultValue = "visitante") String nombre) {
        return bienvenidaService.obtenerSaludoPersonalizado(nombre);
    }
}
