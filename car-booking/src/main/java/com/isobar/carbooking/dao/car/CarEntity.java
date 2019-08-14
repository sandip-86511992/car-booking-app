package com.isobar.carbooking.dao.car;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
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
        return "CarEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
