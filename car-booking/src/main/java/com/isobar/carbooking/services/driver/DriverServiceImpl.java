package com.isobar.carbooking.services.driver;

import com.isobar.carbooking.exceptions.ErrorCodes;
import com.isobar.carbooking.exceptions.ValidationException;
import com.isobar.carbooking.dao.car.CarEntity;
import com.isobar.carbooking.dao.car.CarRepository;
import com.isobar.carbooking.dao.driver.DriverEntity;
import com.isobar.carbooking.dao.driver.DriverRepository;
import com.isobar.carbooking.services.SuccessResponse;
import com.isobar.carbooking.services.car.CarResponse;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CarRepository carRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public DriverResponse create(DriverRequest driverRequest) {
        DriverEntity driverEntity = mapper.map(driverRequest, DriverEntity.class);
        CarEntity carEntity = carRepository.findById(driverRequest.getCarId()).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_CAR_ID));
        driverEntity = driverRepository.save(driverEntity);
        DriverResponse driverResponse = mapper.map(driverEntity, DriverResponse.class);
        driverResponse.setCar(mapper.map(carEntity, CarResponse.class));
        return driverResponse;
    }

    @Override
    public DriverResponse update(String id, DriverRequest driverRequest) {
        DriverEntity driverEntity = mapper.map(driverRequest, DriverEntity.class);
        driverEntity.setId(Long.parseLong(id));
        CarEntity carEntity = carRepository.findById(driverRequest.getCarId()).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_CAR_ID));
        driverEntity = driverRepository.save(driverEntity);
        DriverResponse driverResponse = mapper.map(driverEntity, DriverResponse.class);
        driverResponse.setCar(mapper.map(carEntity, CarResponse.class));
        return driverResponse;
    }

    @Override
    public DriverResponse get(String id) {
        DriverEntity driverEntity = driverRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
        DriverResponse driverResponse = mapper.map(driverEntity, DriverResponse.class);
        driverResponse.setCar(mapper.map(carRepository.findById(driverEntity.getCarId()).get(), CarResponse.class));
        return driverResponse;
    }

    @Override
    public List<DriverResponse> getAll() {
        List<DriverResponse> driverResponses = new ArrayList<>();
        driverRepository.findAll().forEach(driverEntity -> {
            DriverResponse driverResponse = mapper.map(driverEntity, DriverResponse.class);
            driverResponse.setCar(mapper.map(carRepository.findById(driverEntity.getCarId()).get(), CarResponse.class));
            driverResponses.add(driverResponse);
        });
        return driverResponses;
    }

    @Override
    public void delete(String id) {
        DriverEntity driverEntity = driverRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
        driverRepository.delete(driverEntity);
    }

    @Override
    public SuccessResponse assignCar(String id, AssignCarRequest assignCarRequest) {
        SuccessResponse successResponse = new SuccessResponse();
        DriverEntity driverEntity = driverRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
        driverEntity.setCarId(assignCarRequest.getCarId());
        driverEntity = driverRepository.save(driverEntity);
        successResponse.setSuccess(true);
        return successResponse;
    }
}
