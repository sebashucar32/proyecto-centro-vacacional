package co.com.agencia.exception;

import co.com.agencia.exception.message.TechnicalErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TechnicalException extends RuntimeException {
    private final TechnicalErrorMessage technicalErrorMessage;

    public TechnicalException(Throwable cause, TechnicalErrorMessage technicalErrorMessage) {
        super(technicalErrorMessage.getMessage(), cause);
        this.technicalErrorMessage = technicalErrorMessage;
    }
}
