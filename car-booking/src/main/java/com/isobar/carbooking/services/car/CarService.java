package com.isobar.carbooking.services.car;

import java.util.List;

public interface CarService {

    CarResponse create(CarRequest carRequest);
    CarResponse update(String id, CarRequest carRequest);
    CarResponse get(String id);
    List<CarResponse> getAll();
    void delete(String id);

}
