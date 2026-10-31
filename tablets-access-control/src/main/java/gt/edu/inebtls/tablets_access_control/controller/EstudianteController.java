package gt.edu.inebtls.tablets_access_control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import gt.edu.inebtls.tablets_access_control.model.Estudiante;
import gt.edu.inebtls.tablets_access_control.service.EstudianteService;

@Controller
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // 1. Muestra el formulario vacío
    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }

    // 2. Recibe el formulario, guarda y redirige
    @PostMapping("/estudiantes")
    public String registrarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes";
    }

    // 3. Muestra la lista
    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        model.addAttribute("total", estudianteService.contar());
        return "lista";
    }

    // 4. Muestra el detalle de uno solo (ruta parametrizada)
    @GetMapping("/estudiantes/{numero}")
    public String verEstudiante(@PathVariable int numero, Model model) {
        Estudiante estudiante = estudianteService.buscarPorNumero(numero);
        if (estudiante == null) {
            return "redirect:/estudiantes";
        }
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("numero", numero);
        return "detalle";
    }
}