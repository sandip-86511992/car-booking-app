package com.isobar.carbooking.services;

public class SuccessResponse {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "success=" + success +
                '}';
    }
}
