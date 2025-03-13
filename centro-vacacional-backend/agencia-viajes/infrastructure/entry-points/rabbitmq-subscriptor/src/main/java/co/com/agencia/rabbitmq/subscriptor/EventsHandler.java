package co.com.agencia.rabbitmq.subscriptor;

import co.com.agencia.model.stroll.Stroll;
import co.com.agencia.usecase.paseo.RegisterStrollUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@EnableEventListeners
@RequiredArgsConstructor
public class EventsHandler {
    private final RegisterStrollUseCase registerStrollUseCase;

    public Mono<Void> handleRegisterStroll(DomainEvent<Stroll> registerEvent) {
        return registerStrollUseCase.registerStroll(registerEvent.getData()).then();
    }
}
