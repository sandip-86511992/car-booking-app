package com.isobar.carbooking.dao.booking;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long driverId;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
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
        return "BookingEntity{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
