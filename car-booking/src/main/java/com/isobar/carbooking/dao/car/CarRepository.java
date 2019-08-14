package com.isobar.carbooking.dao.car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
}
