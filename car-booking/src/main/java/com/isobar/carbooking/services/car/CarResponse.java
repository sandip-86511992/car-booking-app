package com.isobar.carbooking.services.car;

public class CarResponse {
    private Long id;
    private String name;
    private String registrationNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "CarResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
