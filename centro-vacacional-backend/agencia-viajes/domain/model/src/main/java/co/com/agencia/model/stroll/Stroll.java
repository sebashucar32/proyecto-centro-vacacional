package co.com.agencia.model.stroll;

import co.com.agencia.model.poliza.Poliza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Stroll {
    private Integer idPaseo;
    private String nombreCiudad;
    private String sede;
    private String imagen;
}
