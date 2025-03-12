package co.com.agencia.jpa.stroll;

import co.com.agencia.jpa.poliza.PolizaData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "paseos")
public class StrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paseo")
    private Integer idPaseo;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    private String sede;

    private String imagen;
}
