package extintor_api.repository;

import extintor_api.model.Inspeccion;
import extintor_api.model.Inspeccion.ResultadoInspeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//Marca clases como componentes en capa de persistencia
@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Long> {

    //Métodos tipo querys de SQL para encontrar ciertos datos de las inspecciones

    //Todas las inspecciones de un extintor
    /* findByExtintorId → Java Persistance API entiende que "Extintor" tiene un id y
    hace el JOIN automáticamente, no es necesario escribir nada extra.*/
    List<Inspeccion> findByExtintorId(Long extintorId);

    //Inspecciones por resultado
    List<Inspeccion> findByResultado(ResultadoInspeccion resultado);

    //Inspecciones de un extintor por resultado
    /* findByExtintorIdAndResultado se puede encadenar
    condiciones con And y JPA genera el WHERE correcto:*/
    List<Inspeccion> findByExtintorIdAndResultado(Long extintorId, ResultadoInspeccion resultado);

    //Inspecciones por inspector
    List<Inspeccion> findByInspectorNombre(String inspectorNombre);
}