package extintor_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

//creación de métodos getters/setters
@Data
//Clase como entidad JPA (Java Persistance API), mapeo objeto-relacional
//(datos relacionales en apps Java mediante Objetos)
@Entity
//Nombre de la tabla (distinto a nombre de la clase)
@Table(name = "inspecciones")
public class Inspeccion {
    //id de la tabla
    @Id
    //autogeneración de id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //muchos a uno, un extintor puede tener muchas inspecciones
    @ManyToOne
    //como foreign key en SQL
    @JoinColumn(name = "extintor_id")
    private Extintor extintor;

    @NotNull
    private String inspectorNombre;

    private LocalDateTime fecha = LocalDateTime.now();

    // Checklist
    private Boolean selloSeguridad;
    private Boolean buenEstado;
    private Boolean desapelmazado;
    private Boolean presionAdecuada;
    private Boolean etiquetaLegible;

    private String observaciones;

    @Enumerated(EnumType.STRING)
    private ResultadoInspeccion resultado;

    public enum ResultadoInspeccion {
        APROBADO, RECHAZADO, PENDIENTE
    }
}