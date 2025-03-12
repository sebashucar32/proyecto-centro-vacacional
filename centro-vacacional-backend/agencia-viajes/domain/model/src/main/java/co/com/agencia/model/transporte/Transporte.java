package co.com.agencia.model.transporte;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class Transporte {
    private final Integer idTransporte;
    private final LocalDate fechaIda;
    private final LocalDate fechaVuelta;
    private final String tipoTransporte;
    private final Integer idPaseo;
}
