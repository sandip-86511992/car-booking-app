package com.isobar.carbooking.controllers;

import com.isobar.carbooking.exceptions.ErrorResponse;
import com.isobar.carbooking.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exc) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getErrorCode().getCode());
        errorResponse.setMessage(exc.getErrorCode().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
