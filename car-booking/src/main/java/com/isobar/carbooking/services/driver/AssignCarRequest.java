package com.isobar.carbooking.services.driver;

public class AssignCarRequest {
    private Long carId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "AssignCarRequest{" +
                "carId=" + carId +
                '}';
    }
}
