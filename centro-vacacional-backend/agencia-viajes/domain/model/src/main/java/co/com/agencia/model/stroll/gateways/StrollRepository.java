package co.com.agencia.model.stroll.gateways;

import co.com.agencia.model.stroll.Stroll;
import reactor.core.publisher.Mono;

public interface StrollRepository {
    Mono<Stroll> saveStroll(Stroll stroll);
}
