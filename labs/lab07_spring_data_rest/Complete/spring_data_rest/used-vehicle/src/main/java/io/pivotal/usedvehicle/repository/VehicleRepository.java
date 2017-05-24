package io.pivotal.usedvehicle.repository;

import io.pivotal.usedvehicle.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Vehicles", path = "vehicles")
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {

    Page<Vehicle> findByModelStartsWith(@Param("model") String model, Pageable pageable);

    Page<Vehicle> findByBodyStyle(@Param("bodyStyle") String bodyStyle, Pageable pageable);

    Page<Vehicle> findByMake(@Param("make") String make, Pageable pageable);
}
