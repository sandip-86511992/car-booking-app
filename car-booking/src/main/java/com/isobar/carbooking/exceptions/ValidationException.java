package com.isobar.carbooking.exceptions;

public class ValidationException extends RuntimeException {

    ErrorCodes errorCode;

    public ValidationException(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }
}
