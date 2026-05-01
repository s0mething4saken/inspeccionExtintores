package extintor_api.controller;

import extintor_api.model.Inspeccion;
import extintor_api.model.Inspeccion.ResultadoInspeccion;
import extintor_api.service.InspeccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/inspecciones")
@RequiredArgsConstructor
public class InspeccionController {

    private final InspeccionService inspeccionService;

    // GET /api/inspecciones
    @GetMapping
    public ResponseEntity<List<Inspeccion>> obtenerTodas() {
        return ResponseEntity.ok(inspeccionService.obtenerTodas());
    }

    // GET /api/inspecciones/1
    @GetMapping("/{id}")
    public ResponseEntity<Inspeccion> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inspeccionService.obtenerPorId(id));
    }

    // GET /api/inspecciones/extintor/1
    @GetMapping("/extintor/{extintorId}")
    public ResponseEntity<List<Inspeccion>> obtenerPorExtintor(@PathVariable Long extintorId) {
        return ResponseEntity.ok(inspeccionService.obtenerPorExtintor(extintorId));
    }

    // GET /api/inspecciones/resultado/APROBADO
    @GetMapping("/resultado/{resultado}")
    public ResponseEntity<List<Inspeccion>> obtenerPorResultado(@PathVariable ResultadoInspeccion resultado) {
        return ResponseEntity.ok(inspeccionService.obtenerPorResultado(resultado));
    }

    // POST /api/inspecciones/extintor/1
    @PostMapping("/extintor/{extintorId}")
    public ResponseEntity<Inspeccion> crear(@PathVariable Long extintorId, @Valid @RequestBody Inspeccion inspeccion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inspeccionService.crear(extintorId, inspeccion));
    }

    // DELETE /api/inspecciones/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inspeccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}