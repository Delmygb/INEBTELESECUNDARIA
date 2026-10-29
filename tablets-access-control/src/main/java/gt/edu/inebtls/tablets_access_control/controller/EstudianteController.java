package gt.edu.inebtls.tablets_access_control.controller;

import gt.edu.inebtls.tablets_access_control.model.Estudiante;
import gt.edu.inebtls.tablets_access_control.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        var lista = estudianteService.listarTodos();
        model.addAttribute("estudiantes", lista);
        model.addAttribute("total", lista.size());
        return "lista"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario"; 
    }

    @PostMapping
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteService.buscarPorId(id);
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return "redirect:/estudiantes";
    }
}