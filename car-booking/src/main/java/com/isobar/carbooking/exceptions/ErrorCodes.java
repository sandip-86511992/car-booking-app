package com.isobar.carbooking.exceptions;

public enum ErrorCodes {
    INVALID_DRIVER_ID(1),
    DRIVER_NOT_AVAILABLE(2),
    INVALID_DATE_FORMAT(3),
    INVALID_CAR_ID(4),
    INVALID_BOOKING_ID(5),
    INVAILD_STATUS(6);
    final int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public String getCode() {
        return "car_booking_service_" + code;
    }
}
