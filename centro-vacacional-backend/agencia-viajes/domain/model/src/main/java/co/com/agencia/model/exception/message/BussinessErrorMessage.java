package co.com.agencia.model.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BussinessErrorMessage {
    ERROR_STROLL_INVALID("01", "Error el paseo que se requiere hacer no es valido");

    private final String code;
    private final String message;
}
