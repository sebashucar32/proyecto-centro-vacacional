package co.com.agencia.model.exception;

import co.com.agencia.model.exception.message.BussinessErrorMessage;
import lombok.Getter;

import java.util.Objects;

@Getter
public class BusinessException extends RuntimeException {
    private final BussinessErrorMessage bussinessErrorMessage;
    private final String message;

    public BusinessException(BussinessErrorMessage bussinessErrorMessage) {
        this(bussinessErrorMessage, null);
    }

    public BusinessException(BussinessErrorMessage bussinessErrorMessage, String message) {
        super(bussinessErrorMessage.getMessage());
        this.bussinessErrorMessage = bussinessErrorMessage;
        this.message = message;
    }

    @Override
    public String getMessage() {
        if (Objects.nonNull(message)) {
            return String.format(bussinessErrorMessage.getMessage(), message);
        }

        return super.getMessage();
    }
}
