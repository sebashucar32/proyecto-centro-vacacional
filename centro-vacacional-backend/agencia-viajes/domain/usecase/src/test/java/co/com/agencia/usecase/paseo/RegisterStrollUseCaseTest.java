package co.com.agencia.usecase.paseo;

import co.com.agencia.model.exception.message.BussinessErrorMessage;
import co.com.agencia.model.stroll.Stroll;
import co.com.agencia.model.stroll.gateways.StrollRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class RegisterStrollUseCaseTest {
    @InjectMocks
    private RegisterStrollUseCase registerStrollUseCase;

    @Mock
    private StrollRepository strollRepository;

    private Stroll stroll = null;
    private Stroll strollInvalid = null;
    private Mono<Stroll> newStroll = null;
    private Mono<Stroll> newStrollInvalid = null;

    @BeforeEach
    void init() {
        stroll = Stroll.builder()
            .idPaseo(1)
            .nombreCiudad("Cartagena")
            .sede("San Bernardo")
            .imagen("sanber.jpg")
            .build();
        newStroll = Mono.just(stroll);

        strollInvalid = Stroll.builder()
            .idPaseo(2)
            .nombreCiudad("Santa Marta")
            .sede("San Bernardo")
            .imagen("sanber2.jpg")
            .build();
        newStrollInvalid = Mono.just(strollInvalid);
    }

    @Test
    void shouldRegisterStrollWhenStrollIsValid() {
        Mockito.when(strollRepository.saveStroll(stroll)).thenReturn(newStroll);

        StepVerifier.create(registerStrollUseCase.registerStroll(stroll))
            .assertNext(strollCreated -> {
                assertEquals(strollCreated.getIdPaseo(), stroll.getIdPaseo());
            }).verifyComplete();

        Mockito.verify(strollRepository, Mockito.times(1))
            .saveStroll(any());
    }

    @Test
    void shouldRegisterStrollWhenStrollIsNotValid() {
        Mockito.when(strollRepository.saveStroll(strollInvalid)).thenReturn(newStrollInvalid);

        StepVerifier.create(registerStrollUseCase.registerStroll(strollInvalid))
            .verifyErrorSatisfies(throwable -> {
                assertEquals(BussinessErrorMessage.ERROR_STROLL_INVALID.getMessage(), throwable.getMessage());
            });
    }
}
