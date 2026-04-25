package extintor_api.controller;

import extintor_api.model.Extintor;
import extintor_api.service.ExtintorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //recibe HTTP y devuelve JSON
@RequestMapping("/api/extintores") //la ruta inicial es "/api/extintores/"
@RequiredArgsConstructor //genera el constructor auto
public class ExtintorController {

    private final ExtintorService extintorService;

    //Respuesta petición GET todos los elementos /api/extintores
    @GetMapping
    public ResponseEntity<List<Extintor>> obtenerTodos() {
        return ResponseEntity.ok(extintorService.obtenerTodos());
    }

    //Respuesta petición GET individual /api/extintores/1
    @GetMapping("/{id}")
    public ResponseEntity<Extintor> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(extintorService.obtenerPorId(id));
    }

    //Respuesta peticiones POST /api/extintores
    @PostMapping
    public ResponseEntity<Extintor> crear(@Valid @RequestBody Extintor extintor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(extintorService.crear(extintor));
    }

    //Respuesta a peticiones PUT /api/extintores/1
    @PutMapping("/{id}")
    public ResponseEntity<Extintor> actualizar(@PathVariable Long id, @Valid @RequestBody Extintor extintor) {
        return ResponseEntity.ok(extintorService.actualizar(id, extintor));
    }

    //Respuesta a peticiones DELETE /api/extintores/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        extintorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
