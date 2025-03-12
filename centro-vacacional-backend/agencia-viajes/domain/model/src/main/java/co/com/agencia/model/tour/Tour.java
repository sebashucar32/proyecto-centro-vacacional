package co.com.agencia.model.tour;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Tour {
    private final Integer idTour;
    private final String nombreTour;
    private final String comidas;
    private final LocalDateTime horaInicio;
    private final LocalDateTime horaFin;
    private final Integer idPaseo;
}
