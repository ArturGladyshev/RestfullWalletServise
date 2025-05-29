package org.example.walletRESTapi.exception;

public class IllegalInputException extends RuntimeException {

    public IllegalInputException(InputErrorType parameter) {
        super(parameter.getMessage());
    }

    public IllegalInputException(InputErrorType errorType, String fieldValue) {
        super(errorType.getMessage() + ": " + fieldValue);
    }
}
