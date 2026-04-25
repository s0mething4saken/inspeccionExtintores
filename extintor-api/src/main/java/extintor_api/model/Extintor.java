package extintor_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "extintores")
public class Extintor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String numeroSerie;

    @NotNull
    private String ubicacion;

    private String tipo;           // PQS, CO2, Agua, etc.
    private Double capacidadKg;
    private LocalDate fabricacion;
    private LocalDate ultimoServicio;
    private LocalDate proximoServicio;
    private Boolean activo = true;
}
