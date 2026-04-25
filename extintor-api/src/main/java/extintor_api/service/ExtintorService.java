package extintor_api.service;

import extintor_api.model.Extintor; //imports de otras clases
import extintor_api.repository.ExtintorRepository; //imports de otras clases
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor //generador de constructor automático, no utiliza por ejemplo: extintor new Extintor
public class ExtintorService {

    private final ExtintorRepository extintorRepository;

    //Obtener todos
    public List<Extintor> obtenerTodos() {
        return extintorRepository.findAll();
    }

    // Obtener por id
    public Extintor obtenerPorId(Long id) {
        return extintorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Extintor no encontrado con id: " + id)); //Manejador de errores
    }

    // Crear nuevo
    public Extintor crear(Extintor extintor) {
        return extintorRepository.save(extintor);
    }

    // Actualizar
    public Extintor actualizar(Long id, Extintor datos) {
        Extintor extintor = obtenerPorId(id);
        extintor.setNumeroSerie(datos.getNumeroSerie());
        extintor.setUbicacion(datos.getUbicacion());
        extintor.setTipo(datos.getTipo());
        extintor.setCapacidadKg(datos.getCapacidadKg());
        extintor.setFabricacion(datos.getFabricacion());
        extintor.setUltimoServicio(datos.getUltimoServicio());
        extintor.setProximoServicio(datos.getProximoServicio());
        extintor.setActivo(datos.getActivo());
        return extintorRepository.save(extintor);
    }

    // Eliminar
    public void eliminar(Long id) {
        extintorRepository.deleteById(id);
    }

    // Solo activos
    public List<Extintor> obtenerActivos() {
        return extintorRepository.findByActivoTrue();
    }
}
