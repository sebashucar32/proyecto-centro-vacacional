package co.com.agencia.model.poliza;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Poliza {
    private Integer idPoliza;
    private Integer valorPoliza;
    private Integer valorAsegurado;
    private String contrato;
}
