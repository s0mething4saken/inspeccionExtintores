package extintor_api.repository;

import extintor_api.model.Extintor; //com.extintor.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExtintorRepository extends JpaRepository<Extintor, Long> {

    // Buscar por número de serie
    Extintor findByNumeroSerie(String numeroSerie);

    // Buscar solo los activos
    List<Extintor> findByActivoTrue();

    // Buscar por ubicación
    List<Extintor> findByUbicacion(String ubicacion);
}
