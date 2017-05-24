package io.pivotal.usedvehicle.repository;

import io.pivotal.usedvehicle.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findByBodyStyle(String bodyStyle);
    List<Vehicle> findByMake(String make);
}
