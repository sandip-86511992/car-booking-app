package com.isobar.carbooking.services.booking;

import com.isobar.carbooking.dao.booking.BookingStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class BookingResponse {
    private Long id;
    private Long driverId;
    private Long carId;
    private Date startTime;
    private Date endTime;
    private BookingStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
