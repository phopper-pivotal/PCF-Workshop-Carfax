# Spring Data

## let's build an entity
1. navigate to start.spring.io
2. configure your project
   * group name (use **_'io.pivotal'_**')
   * artifact name (use **_'used-vehicle'_**)
   * *_maven_* for your build system
   * spring boot version 1.5.3
4. add dependencies
   *  Web
   *  JPA
   *  H2
   *  Actuator
5. select 'Generate Project'
6. unzip the downloaded file
7. open your favorite IDE
   *  import project root
   *  java 8, use by default (if not installed, go download. god speed)
8. open pom.xml - what starters are there?
9. create package io.pivotal.domain
10. create class **_Vehicle_**
    *  add `@Entity` (javax.persistence.Entity) annotation to class
    *  add `implements Serializable` to the class signature
    *  add attributes 
       *  listDate
       *  price
       *  mileage
       *  location
       *  exteriorColor
       *  interiorColor
       *  driveType
       *  transmission
       *  bodyStyle
       *  engine
       *  fuel
       *  vin
       *  stockNumber
       *  mpgCity
       *  mpgHighway
       *  features
       *  description
       * add an attribute, generated value for Vehicle identifier (see example below)
    *  use IDE to generate getter/setter methods
    *  use IDE to generate a default constructor void of and attributes as arguments
    *  use IDE to generate a constructor that takes all attributes as arguments
    *  use IDE to generate a toString method
    *  your code should look something like this       
```java
package io.pivotal.usedvehicle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String listDate;
    private String manufacturedYear;
    private String make;
    private String model;
    private long price;
    private long mileage;
    private String location;
    private String exteriorColor;
    private String interiorColor;
    private String driveType;
    private String transmission;
    private String bodyStyle;
    private String engine;
    private String fuel;
    private String vin;
    private String stockNumber;
    private int mpgCity;
    private int mpgHighway;
    private String features;
    private String description;

    public Vehicle() {}

    public Vehicle(String listDate, String manufacturedYear, String make, String model, long price, long mileage, String location, String exteriorColor,
                   String interiorColor, String driveType, String transmission, String bodyStyle,
                   String engine, String fuel, String vin, String stockNumber, int mpgCity, int mpgHighway,
                   String features, String description) {
        this.listDate = listDate;
        this.manufacturedYear = manufacturedYear;
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
        this.location = location;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.driveType = driveType;
        this.transmission = transmission;
        this.bodyStyle = bodyStyle;
        this.engine = engine;
        this.fuel = fuel;
        this.vin = vin;
        this.stockNumber = stockNumber;
        this.mpgCity = mpgCity;
        this.mpgHighway = mpgHighway;
        this.features = features;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getListDate() {
        return listDate;
    }

    public void setListDate(String listDate) {
        this.listDate = listDate;
    }

    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getMpgCity() {
        return mpgCity;
    }

    public void setMpgCityCity(int mgpCity) {
        this.mpgCity = mpgCity;
    }

    public int getMpgHighway() {
        return mpgHighway;
    }

    public void setMpgHighway(int mpgHighway) {
        this.mpgHighway = mpgHighway;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", listDate='" + listDate + '\'' +
                ", manufacturedYear='" + manufacturedYear + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + '\'' +
                ", mileage=" + mileage + '\'' +
                ", location='" + location + '\'' +
                ", exteriorColor='" + exteriorColor + '\'' +
                ", interiorColor='" + interiorColor + '\'' +
                ", driveType='" + driveType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", engine='" + engine + '\'' +
                ", fuel='" + fuel + '\'' +
                ", vin='" + vin + '\'' +
                ", stockNumber='" + stockNumber + '\'' +
                ", mgpCity=" + mpgCity +
                ", mpgHighway=" + mpgHighway +
                ", features='" + features + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
```

## now expose the entity through a repository
1. create package io.pivotal.repository
2. create interface **_VehicleRepository_**
   *  add `extends CrudRepository<Vehicle, Long>` to the interface
   *  add method `List<Vehicle> findByBodyStyle(String bodyStyle);` to the interface

## a CommandLineRunner is our friend
1. let's load this entity backed by H2 with data
  *  add the code below to UsedVehicleApplication class 
```java
@Bean
public CommandLineRunner run(VehicleRepository vehicleRepository) {
    return (args) -> {
        // save a couple of Vehicles
        vehicleRepository.save(new Vehicle("2017-05-23", "2015", "Toyota", "RAV4 XLE", 22272, 11426, "65201", "Red", "Black", "FWD", "Automatic", "SUV",
                                "4 Cyl", "Gasoline", "2T3WFREVXFW223703", "TN223703", 20, 30, "", ""));
        vehicleRepository.save(new Vehicle("2017-05-23", "2014", "Nissan", "Nissan Rogue S", 14738, 34667, "65201", "White", "Black", "AWD", "Automatic", "SUV",
                "4 Cyl", "Gasoline", "JN8AS5MV5EW701806", "PN701806", 22, 27, "", ""));
        vehicleRepository.save(new Vehicle("2017-05-23", "2015", "Kia", "Sorento LX", 17980, 26383, "65201", "Silver", "Black", "AWD", "Automatic", "SUV",
                "4 Cyl", "Gasoline", "5XYKT3A66FG595301", "PK595301", 20, 27, "", ""));
        vehicleRepository.save(new Vehicle("2017-05-23", "2014", "Volkswagen", "Tiguan S", 14997, 40525, "65201", "Gray", "Black", "AWD", "Automatic", "SUV",
                "4 Cyl", "Gasoline", "WVGBV3AXXEW619101", "PH619101", 20, 26, "", ""));

        // fetch all vehicle
        System.out.println("Vehicles found with findAll()");
        System.out.println("---------------------------");
        for (Vehicle Vehicle : vehicleRepository.findAll()) {
            System.out.println(Vehicle.toString());
        }


        // fetch one vehicle
        System.out.println("Vehicles found with findOne()");
        System.out.println("---------------------------");
        Vehicle Vehicle = vehicleRepository.findOne(1L);


        // fetch vehicle by body style
        System.out.println("Vehicles found with findByBodyStyle('SUV')");
        System.out.println("---------------------------");
        for (Vehicle suv : vehicleRepository.findByBodyStyle("SUV")) {
            System.out.println(suv.toString());
        }
    };
}
```
2. from project root directory, run `mvn sprint-boot:run`

**_what just happened?_**

**_how much boilerplate code did we have to introduce?_**

## can we query by other attributes
1. let's add some other methods to retrieve our Vehicles
   *  add a method to **_VehicleRepository_** to findByMake `List<Vehicle> findByMake(String make);`
   *  add code to the CommandLineRunner in **_UsedVehicleApplication_** to output findByMake
  
```java
// fetch Vehicles by make
System.out.println("Vehicles found with findByMake('Toyota')");
System.out.println("---------------------------");
System.out.println(vehicleRepository.findByMake("Kia").toString());
System.out.println();
```
2. from project root directory, run `mvn sprint-boot:run`

**_what just happened?_**

## that's great but what about wildcards
1. let's add some wildcard method to retrieve where genre starts with "Animation"
2. add a method findByModelStartsWith to **_VehicleRepository_**
```java
List<Vehicle> findByModelStartsWith(String model);
---------------------------------------------------------------------
```
3. add code to the CommandLineRunner in *_UsedVehicleApplication_* to output findByVinStartsWith
```java
// fetch Vehicles by make
System.out.println("Vehicles found with findByModel("Sor")");
System.out.println("---------------------------");
for (Vehicle kia : vehicleRepository.findByModel("Sor")) {
    System.out.println(kia.toString());
}
System.out.println();
```
4. from project root directory, run `mvn sprint-boot:run`

**_isn't this just awesome, only need to add a single method to expose the data_**

**_no longer embedding queries to my datastore_**

**_no longer handling JDBC connections or JDBCTemplate or EntityMangerFactories_**

**_no longer using @NamedQueries_**

**_no longer using prepared statements_**

# cf push
1. let's create a manifest.yml at the top level of your project
```yml
---
applications:
- name: used-vehicle
  buildpack: java_buildpack_offline
  host: used-vehicle-${random-word}
  path: target/used-vehicle-0.0.1-SNAPSHOT.jar
```
2. `cf push`

3. `cf apps` will show you all the deployed apps in your space along with their vital stats and mapped routes.  Notice the random words from the manifest file.
```
$ cf apps
Getting apps in org test / space dev as admin...
OK

name            requested state   instances   memory   disk   urls
attendees       started           3/3         512M     1G     attendees-unconsecrative-roundhouse.apps.pcf-apps.net
cf-scale-boot   started           5/5         512M     1G     cf-scale-boot-arcifinious-wolver.apps.pcf-apps.net
spring-music    started           1/1         512M     1G     spring-music-chondromatous-hydrographer.apps.pcf-apps.net
used-vehicle    started           1/1         1G       1G     used-vehicle-unburstable-nurturer.apps.pcf-apps.net
```
4. verify your app at its new randomly-generated route

5. `cf logs used-vehicle --recent` to see the logs from the app

# extra credit
given we can use methods on the *_VehicleRepository_* to retrieve data what other ways can you query for wildcards

[shhh here's a hint](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

[Course Materials home](../../README.md#labs)

[Lab 7 - Spring Data REST](../lab07_spring_data_rest/README.md)
