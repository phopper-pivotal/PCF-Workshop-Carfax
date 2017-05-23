# Lab 4: Spring Data

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
       * add an attribute, generated value for movie identifier (see example below)
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
    private Number price;
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
    private int mgpCity;
    private int mpgHighway;
    private String features;
    private String description;

    private Vehicle() {}

    public Vehicle(String listDate, Number price, long mileage, String location, String exteriorColor, String interiorColor, String driveType, String transmission, String bodyStyle, String engine, String fuel, String vin, String stockNumber, int mgpCity, int mpgHighway, String features, String description) {
        this.listDate = listDate;
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
        this.mgpCity = mgpCity;
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

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
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

    public int getMgpCity() {
        return mgpCity;
    }

    public void setMgpCity(int mgpCity) {
        this.mgpCity = mgpCity;
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
                ", price=" + price +
                ", mileage=" + mileage +
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
                ", mgpCity=" + mgpCity +
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
   *  add method `List<Movie> findByVin(String title);` to the interface

## a CommandLineRunner is our friend
1. let's load this entity backed by H2 with data
  *  add the code below to WatchingApplication class 
```java
    @Bean
    public CommandLineRunner demo(MovieRepository vehicleRepository) {
        return (args) -> {
            // save a couple of movies
            vehicleRepository.save(new Vehicle("Frozen", "2013", "PG", "27 Nov 2013", "102 min", "Animation, Adventure, Comedy"));
            vehicleRepository.save(new Vehicle("Toy Story", "1995", "G", "22 Nov 1995", "81 min", "Animation, Adventure, Comedy"));
            vehicleRepository.save(new Vehicle("Muppets Most Wanted", "2014", "PG", "21 Mar 2014", "107 min", "Adventure, Comedy, Crime"));
            vehicleRepository.save(new Vehicle("The Incredibles", "2004", "PG", "05 Nov 204", "115 min", "Animation, Action, Adventure"));

            // fetch all movies
            System.out.println("Vehicle found with findAll()");
            System.out.println("---------------------------");
            for (Vehicle movie : vehicleRepository.findAll()) {
                System.out.println(movie.toString());
            }


            // fetch one movie
            System.out.println("Vehicle found with findOne()");
            System.out.println("---------------------------");
            Movie Vehicle = vehicleRepository.findOne(1L);


            // fetch movies by title
            System.out.println("Vehicle found with findByTitle('Frozen')");
            System.out.println("---------------------------");
            for (Vehicle frozen : vehicleRepository.findByVin("Frozen")) {
                System.out.println(frozen.toString());
            }

        };
    }
```
2. from project root directory, run `mvn sprint-boot:run`

**_what just happened?_**

**_how much boilerplate code did we have to introduce?_**

## can we query by other attributes
1. let's add some other methods to retrieve our movies
   *  add a method to **_MovieRepository_** to findByRated `List<Movie> findByRated(String rated);`
   *  add code to the CommandLineRunner in **_WatchingApplication_** to output findByRated
  
```java
// fetch movies by rated
System.out.println("Movies found with findByRating('G'");
System.out.println("---------------------------");
System.out.println(movieRepository.findByRated("G").toString());
System.out.println();
```
2. from project root directory, run `mvn sprint-boot:run` +

**_what just happened?_**

## that's great but what about wildcards
1. let's add some wildcard method to retrieve where genre starts with "Animation"
2. add a method findByGenreStartsWith to **_MovieRepository_**
```java
List<Movie> findByGenreStartsWith(String genre);
---------------------------------------------------------------------
```
3. add code to the CommandLineRunner in *_WatchingApplication_* to output findByRated
```java
// fetch movies by rated
System.out.println("Movies found with findByGenreStartsWith('Animation'");
System.out.println("---------------------------");
movieRepository.findByGenreStartsWith("Animation").forEach(genres -> System.out.println(genres));
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
- name: hello
  buildpack: java_buildpack
  host: hello-${random-word}
  path: target/hello-0.0.1-SNAPSHOT.jar
```
2. `cf push`

3. `cf apps` will show you all the deployed apps in your space along with their vital stats and mapped routes.  Notice the random words from the manifest file.
```
$ cf apps
Getting apps in org Vertical / space rhardt-sandbox as rhardt@pivotal.io...
OK

name                  requested state   instances   memory   disk   urls
hello                 started           1/1         1G       1G     hello-unscaled-multimillion.cfapps.io
```
4. verify your app at its new randomly-generated route

# extra credit
given we can use methods on the *_MovieRepository_* to retrieve data what other ways can you query for wildcards + 

[shhh here's a hint](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

[Course Materials home](../../README.md#labs)

[Lab 7 - Spring Data REST](../lab06_spring_actuator/README.md)
