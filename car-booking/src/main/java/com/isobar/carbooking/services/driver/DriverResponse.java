package com.isobar.carbooking.services.driver;

import com.isobar.carbooking.services.car.CarResponse;

public class DriverResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private CarResponse car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CarResponse getCar() {
        return car;
    }

    public void setCar(CarResponse car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "DriverResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", car=" + car +
                '}';
    }
}
