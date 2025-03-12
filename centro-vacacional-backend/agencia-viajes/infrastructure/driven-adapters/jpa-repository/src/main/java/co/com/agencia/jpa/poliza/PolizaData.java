package co.com.agencia.jpa.poliza;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "poliza")
public class PolizaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poliza")
    private Integer idPoliza;

    @Column(name = "valor_poliza")
    private Integer valorPoliza;

    @Column(name = "valor_asegurado")
    private Integer valorAsegurado;

    private String contrato;
}
