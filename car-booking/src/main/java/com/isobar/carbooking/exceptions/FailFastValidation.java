package com.isobar.carbooking.exceptions;

import java.util.function.Predicate;

public class FailFastValidation {
    public static final Predicate<String> isNull = str -> str == null || str.isEmpty();
    public static final <T> void testAndThrowValidationException(Predicate<T> predicate,  T object, ErrorCodes errorCode) {
        if (predicate.test(object)) {
            throw new ValidationException(errorCode);
        }
    }
}
