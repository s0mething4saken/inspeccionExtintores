package extintor_api.exception;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiException {
    private int status;
    private String mensaje;
    private String ruta;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiException(int status, String mensaje, String ruta) {
        this.status = status;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }
}