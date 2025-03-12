package co.com.agencia.model.stroll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrollConstants {
    public static final Map<String, List<String>> STROLLS_TYPES = new HashMap<>(){{
        put("Santa Marta", new ArrayList<>(List.of("Tayrona", "Playa Blanca")));
        put("Cartagena", new ArrayList<>(List.of("San Bernardo", "Baru")));
        put("San Andres", new ArrayList<>(List.of("Acuario", "Hoyo Soplador")));
    }};
}
