package extintor_api.service;

import extintor_api.model.Inspeccion;
import extintor_api.model.Inspeccion.ResultadoInspeccion;
import extintor_api.repository.InspeccionRepository;
import extintor_api.repository.ExtintorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InspeccionService {

    private final InspeccionRepository inspeccionRepository;
    private final ExtintorRepository extintorRepository;

    // Obtener todas
    public List<Inspeccion> obtenerTodas() {
        return inspeccionRepository.findAll();
    }

    // Obtener por id
    public Inspeccion obtenerPorId(Long id) {
        return inspeccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inspección no encontrada con id: " + id));
    }

    // Obtener por extintor
    public List<Inspeccion> obtenerPorExtintor(Long extintorId) {
        return inspeccionRepository.findByExtintorId(extintorId);
    }

    // Obtener por resultado
    public List<Inspeccion> obtenerPorResultado(ResultadoInspeccion resultado) {
        return inspeccionRepository.findByResultado(resultado);
    }

    // Crear nueva inspección
    public Inspeccion crear(Long extintorId, Inspeccion inspeccion) {
        Inspeccion nuevaInspeccion = extintorRepository.findById(extintorId)
                .map(extintor -> {
                    inspeccion.setExtintor(extintor);
                    return inspeccionRepository.save(inspeccion);
                })
                .orElseThrow(() -> new RuntimeException("Extintor no encontrado con id: " + extintorId));
        return nuevaInspeccion;
    }

    // Eliminar
    public void eliminar(Long id) {
        inspeccionRepository.deleteById(id);
    }
}