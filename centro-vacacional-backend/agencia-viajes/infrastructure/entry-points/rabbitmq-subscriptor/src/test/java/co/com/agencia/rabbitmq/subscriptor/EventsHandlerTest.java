package co.com.agencia.rabbitmq.subscriptor;

import co.com.agencia.model.stroll.Stroll;
import co.com.agencia.usecase.paseo.RegisterStrollUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class EventsHandlerTest {
    @InjectMocks
    private EventsHandler eventsHandler;

    @Mock
    private RegisterStrollUseCase registerStrollUseCase;

    @Test
    void shouldRegisterStrollWhenHandleIsSuccessfull() {
        Stroll stroll = Stroll.builder()
            .idPaseo(1)
            .nombreCiudad("Cartagena")
            .sede("San Bernardo")
            .imagen("sanber.jpg")
            .build();

        DomainEvent<Stroll> domainEvent = new DomainEvent<>("", "", stroll);

        Mockito.when(registerStrollUseCase.registerStroll(stroll)).thenReturn(Mono.empty());
        StepVerifier.create(eventsHandler.handleRegisterStroll(domainEvent))
            .verifyComplete();
    }
}