package extintor_api.controller;

import extintor_api.service.ExtintorService;
import extintor_api.service.InspeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import extintor_api.model.Extintor;
import org.springframework.web.bind.annotation.*;

@Controller //Devuelve el ombre d euna vista HTML
@RequestMapping("/extintores")
@RequiredArgsConstructor
public class ExtintorWebController {

    private final ExtintorService extintorService;
    private final InspeccionService inspeccionService;

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("extintores", extintorService.obtenerTodos());
        //para acceder en HTMl colocar ${extintores}
        return "extintores/lista"; //templates/extintoreslista.html
    }
    // Mostrar formulario nuevo
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("extintor", new Extintor());
        return "extintores/form";
    }

    // Mostrar formulario editar
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("extintor", extintorService.obtenerPorId(id));
        return "extintores/form";
    }

    // Guardar nuevo o editado
    @PostMapping("/guardar")
    public String guardar(Extintor extintor) {
        if (extintor.getId() != null) {
            extintorService.actualizar(extintor.getId(), extintor);
        } else {
            extintorService.crear(extintor);
        }
        return "redirect:/extintores";
    }
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        extintorService.eliminar(id);
        return "redirect:/extintores";
    }
    @GetMapping("/{id}/inspecciones")
    public String inspecciones(@PathVariable Long id, Model model) {
        model.addAttribute("extintor", extintorService.obtenerPorId(id));
        model.addAttribute("inspecciones", inspeccionService.obtenerPorExtintor(id));
        return "extintores/inspecciones";
    }
}


