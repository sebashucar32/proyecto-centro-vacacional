package co.com.agencia.usecase.paseo;

import co.com.agencia.model.exception.BusinessException;
import co.com.agencia.model.exception.message.BussinessErrorMessage;
import co.com.agencia.model.stroll.Stroll;
import co.com.agencia.model.stroll.gateways.StrollRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static co.com.agencia.model.stroll.StrollConstants.STROLLS_TYPES;

@RequiredArgsConstructor
public class RegisterStrollUseCase {
    private final StrollRepository strollRepository;

    public Mono<Stroll> registerStroll(Stroll stroll) {
        return validateStroll(stroll)
            .switchIfEmpty(Mono.defer(() -> Mono.error(
                new BusinessException(BussinessErrorMessage.ERROR_STROLL_INVALID))))
            .flatMap(strollRepository::saveStroll);
    }

    // TODO: en este metodo se podria cambiar la constante de los STROLLS_TYPES por valores en un pipeline
    public Mono<Stroll> validateStroll(Stroll stroll) {
        return Mono.defer(() -> {
            var sedes = STROLLS_TYPES.get(stroll.getNombreCiudad());

            return Mono.justOrEmpty(sedes)
                .filter(sede -> sede.contains(stroll.getSede()))
                .map(seda -> stroll);
        });
    }
}

