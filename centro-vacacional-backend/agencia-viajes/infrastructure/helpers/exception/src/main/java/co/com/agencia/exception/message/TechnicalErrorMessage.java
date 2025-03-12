package co.com.agencia.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TechnicalErrorMessage {
    ERROR_EVENT_HANDLER("01", "Error recibiendo el mensaje en el handler");
    private final String code;
    private final String message;
}
