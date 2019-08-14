package com.isobar.carbooking.services.car;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CarRequest {

    private String name;
    private String registrationNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "CarRequest{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
