package com.isobar.carbooking.controllers;

import com.isobar.carbooking.services.car.CarRequest;
import com.isobar.carbooking.services.car.CarResponse;
import com.isobar.carbooking.services.car.CarService;
import com.isobar.carbooking.services.car.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController extends BaseController{

    @Autowired
    CarServiceImpl carService;

    @RequestMapping(method = RequestMethod.POST)
    public CarResponse create(@RequestBody  CarRequest carRequest) {
        return carService.create(carRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CarResponse update(@PathVariable String id, @RequestBody  CarRequest carRequest) {
        return carService.update(id, carRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CarResponse get(@PathVariable String id) {
        return carService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        carService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CarResponse> get() {
        return carService.getAll();
    }

}
