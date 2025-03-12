package co.com.agencia.jpa.stroll;

import co.com.agencia.model.stroll.Stroll;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertidorStroll {
    public static StrollData convertStrollToStrollData(Stroll stroll) {
        return StrollData.builder()
            .idPaseo(stroll.getIdPaseo())
            .nombreCiudad(stroll.getNombreCiudad())
            .sede(stroll.getSede())
            .imagen(stroll.getImagen())
            .build();
    }
}
