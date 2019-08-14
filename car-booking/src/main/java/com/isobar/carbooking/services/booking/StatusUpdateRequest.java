package com.isobar.carbooking.services.booking;

public class StatusUpdateRequest {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusUpdateRequest{" +
                "status='" + status + '\'' +
                '}';
    }
}
