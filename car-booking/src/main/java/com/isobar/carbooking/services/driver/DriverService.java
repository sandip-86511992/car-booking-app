package com.isobar.carbooking.services.driver;

import com.isobar.carbooking.services.SuccessResponse;
import com.isobar.carbooking.services.car.CarRequest;
import com.isobar.carbooking.services.car.CarResponse;

import java.util.List;

public interface DriverService {
    DriverResponse create(DriverRequest driverRequest);
    DriverResponse update(String id, DriverRequest driverRequest);
    DriverResponse get(String id);
    List<DriverResponse> getAll();
    void delete(String id);
    SuccessResponse assignCar(String id, AssignCarRequest assignCarRequest);
}
