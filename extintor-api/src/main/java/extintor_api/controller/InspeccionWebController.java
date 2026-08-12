package extintor_api.controller;

import extintor_api.model.Inspeccion;
import extintor_api.service.InspeccionService;
import extintor_api.service.ExtintorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inspecciones")
@RequiredArgsConstructor
public class InspeccionWebController {

    private final InspeccionService inspeccionService;
    private final ExtintorService extintorService;

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("inspecciones", inspeccionService.obtenerTodas());
        return "inspecciones/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("inspeccion", new Inspeccion());
        model.addAttribute("extintores", extintorService.obtenerTodos());
        return "inspecciones/form";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam Long extintorId, Inspeccion inspeccion) {
        inspeccionService.crear(extintorId, inspeccion);
        return "redirect:/inspecciones";
    }
    @GetMapping("/{id}/detalle")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("inspeccion", inspeccionService.obtenerPorId(id));
        return "inspecciones/detalle";
    }
}