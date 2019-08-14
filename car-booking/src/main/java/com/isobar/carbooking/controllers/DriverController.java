package com.isobar.carbooking.controllers;

import com.isobar.carbooking.services.SuccessResponse;
import com.isobar.carbooking.services.driver.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/driver")
public class DriverController extends BaseController{

    @Autowired
    DriverServiceImpl driverService;

    @RequestMapping(method = RequestMethod.POST)
    public DriverResponse create(@RequestBody DriverRequest driverRequest) {
        return driverService.create(driverRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DriverResponse update(@PathVariable String id,  @RequestBody DriverRequest driverRequest) {
        return driverService.update(id, driverRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DriverResponse get(@PathVariable String id) {
        return driverService.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        driverService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DriverResponse> getAll() {
        return driverService.getAll();
    }

    @RequestMapping(value = "/assign-car/{id}", method = RequestMethod.PATCH)
    public SuccessResponse assignCar(@PathVariable String id,  AssignCarRequest assignCarRequest) {
        return driverService.assignCar(id, assignCarRequest);
    }

}
