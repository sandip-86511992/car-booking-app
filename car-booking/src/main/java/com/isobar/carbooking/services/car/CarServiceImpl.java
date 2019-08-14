package com.isobar.carbooking.services.car;

import com.isobar.carbooking.dao.car.CarRepository;
import com.isobar.carbooking.dao.car.CarEntity;
import com.isobar.carbooking.dao.driver.DriverEntity;
import com.isobar.carbooking.exceptions.ErrorCodes;
import com.isobar.carbooking.exceptions.ValidationException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public CarResponse create(CarRequest carRequest) {
        CarEntity carEntity = mapper.map(carRequest, CarEntity.class);
        carEntity = carRepository.save(carEntity);
        CarResponse carResponse = mapper.map(carEntity, CarResponse.class);
        return carResponse;
    }

    @Override
    public CarResponse update(String id, CarRequest carRequest) {
        CarEntity carEntity = mapper.map(carRequest, CarEntity.class);
        carEntity.setId(Long.parseLong(id));
        carEntity = carRepository.save(carEntity);
        CarResponse carResponse = mapper.map(carEntity, CarResponse.class);
        return carResponse;
    }

    @Override
    public CarResponse get(String id) {
        CarEntity carEntity = carRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
        CarResponse carResponse = mapper.map(carEntity, CarResponse.class);
        return carResponse;
    }

    @Override
    public List<CarResponse> getAll() {
        List<CarResponse> carResponses = new ArrayList<>();
        carRepository.findAll().forEach(carEntity -> carResponses.add(mapper.map(carEntity, CarResponse.class)));
        return carResponses;
    }

    @Override
    public void delete(String id) {
        CarEntity carEntity = carRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
        carRepository.delete(carEntity);
    }
}
