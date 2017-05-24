# Spring Data REST

## we need Spring Boot's starter for Data REST
1. navigate to your project from lab 6
2. open the `pom.xml` from lab 6
3. add the following dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>    
```

## expose our VehicleRepository
1. add `@RepositoryRestResource` annotation to **_VehicleRepository_**
   * add attribute `collectionResourceRel = "Vehicles"` to @RepositoryRestResource annotation
   * add attribute `path = "vehicles"` to @RepositoryRestResource annotation
2. code should look a little something like this

```java
package io.pivotal.usedvehicle.repository;

import io.pivotal.usedvehicle.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Vehicles", path = "vehicles")
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findByBodyStyle(String bodyStyle);
    List<Vehicle> findByMake(String make);
}
```
   
3. stop your previous version if it is still running
4. `./mvnw spring-boot:run`
5. visit http://localhost:8080/vehicles
6. follow the various links

## let their be data
1. we can see there's data from the **_UsedVehicleApplication.run()_**
   * we can POST data to the VehicleRepository RESTful service
`curl -i -X POST -H "Content-Type:application/json" -d '{"listDate" : "2017-05-24", "manufacturedYear" : "2014", "make" : "Infinit", "model" : "QX50 Journey", "price" : 24999, "mileage" : 29381, "location" : 65201, "exteriorColor" : "Black", "interiorColor" : "Black", "driveType" : "AWD", "transmission" : "Automatic", "bodyStyle" : "SUV", "engine" : "4 Cyl", "fuel" : "Gasoline", "vin" : "JN1BJ0HR6EM190690", "stockNumber" : "PN190690", "mpgCity" : 17, "mpgHighway" : 24, "features" : "", "description" : "" }' http://localhost:8080/vehicles/`
2. visit http://localhost:8080/Vehicles

## open the flood gates
1. let's preload some data
   * copy labs/lab07_spring_data_rest/import.sql to src/main/resources
   * stop your previous version if it is still running
   * comment out the **_UsedVehicleApplication.run()_** method
2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/Vehicles
4. follow the various links

##  failed to search for you
1. let's fix search, in case you noticed there were errors
   * visit http://localhost:8080/Vehicles/search/findByBodyStyle?bodyType#SUV
   * let's modify **_VehicleRepository_**
       * add @Param("bodyType") as in `List<Vehicle> findByBodyStyle(@Param("bodyType") String bodyStyle);`
       * add @Param("make") as in `List<Vehicle> findByMake(@Param ("make") String make);`
       * add @Param("model") as in `Page<Vehicle> findByModelStartsWith(@Param("model") String model, Pageable pageable);`
2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/vehicles/search/findByBodyStyle?bodyStyle=SUV
4. visit http://localhost:8080/vehicles/search/findByMake?make=Kia

## pagination
1. let's enable pagination
   * change CrudRepository in **_VehicleRepository_** to use PagingAndSortingRepository
   * change return type from List<Vehicle> to Page<Vehicle>
   * add extra argument to each findBy method as in `@Param("make") String make, Pageable pageable`
   * should now look like
```java
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
```

2. `./mvnw spring-boot:run`
3. visit http://localhost:8080/Vehicles/
4. scroll to bottom of page to see pagination enabled
5. now visit http://localhost:8080/vehicles/search/findByModelStartsWith?model=So&sort=price
6. verify sort order by price of Vehicle
7. verify sort order by listDate of Vehicle (hint: change price to listDate in sort option)

## cf push

1. repackage `./mvnw clean package`
2. push your app:  `cf push`
3. let's verify our changes
4. visit http://hello-your-random.yoursite.com/vehicles/search/findByBodyStyle?bodyStyle=SUV
5. visit http://hello-your-random.yoursite.com/vehicles/search/findByMake?make=Kia
6. visit http://hello-your-random.yoursite.com/vehicles/search/findByModelStartsWith?model=So&sort=price

[Course Materials home](../../README.md#labs)