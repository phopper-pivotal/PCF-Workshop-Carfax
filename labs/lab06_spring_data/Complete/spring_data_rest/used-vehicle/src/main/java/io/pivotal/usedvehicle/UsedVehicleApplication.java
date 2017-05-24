package io.pivotal.usedvehicle;

import io.pivotal.usedvehicle.domain.Vehicle;
import io.pivotal.usedvehicle.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsedVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsedVehicleApplication.class, args);
	}

    @Bean
    public CommandLineRunner run(VehicleRepository vehicleRepository) {
        return (args) -> {
            // save a couple of movies
            vehicleRepository.save(new Vehicle("2017-05-23", "2015", "Toyota", "RAV4 XLE", 22272, 11426, "65201", "Red", "Black", "FWD", "Automatic", "SUV",
                    "4 Cyl", "Gasoline", "2T3WFREVXFW223703", "TN223703", 20, 30, "", ""));
            vehicleRepository.save(new Vehicle("2017-05-22", "2014", "Nissan", "Nissan Rogue S", 14738, 34667, "65201", "White", "Black", "AWD", "Automatic", "SUV",
                    "4 Cyl", "Gasoline", "JN8AS5MV5EW701806", "PN701806", 22, 27, "", ""));
            vehicleRepository.save(new Vehicle("2017-05-21", "2015", "Kia", "Sorento LX", 17980, 26383, "65201", "Silver", "Black", "AWD", "Automatic", "SUV",
                    "4 Cyl", "Gasoline", "5XYKT3A66FG595301", "PK595301", 20, 27, "", ""));
            vehicleRepository.save(new Vehicle("2017-05-20", "2014", "Volkswagen", "Tiguan S", 14997, 40525, "65201", "Gray", "Black", "AWD", "Automatic", "SUV",
                    "4 Cyl", "Gasoline", "WVGBV3AXXEW619101", "PH619101", 20, 26, "", ""));
            vehicleRepository.save(new Vehicle("2017-05-19", "2014", "Kia", "Sorento LX", 15974, 40525, "65201", "White", "Black", "AWD", "Automatic", "SUV",
                    "4 Cyl", "Gasoline", "5XYKTCA69EG517125", "PK517125", 19, 24, "", ""));

            // fetch all vehicle
            System.out.println("Vehicles found with findAll()");
            System.out.println("---------------------------");
            for (Vehicle movie : vehicleRepository.findAll()) {
                System.out.println(movie.toString());
            }


            // fetch one vehicle
            System.out.println("Vehicles found with findOne()");
            System.out.println("---------------------------");
            Vehicle movie = vehicleRepository.findOne(1L);


            // fetch vehicle by body style
            System.out.println("Vehicles found with findByBodyStyle('SUV')");
            System.out.println("---------------------------");
            for (Vehicle frozen : vehicleRepository.findByBodyStyle("SUV")) {
                System.out.println(frozen.toString());
            }

            // fetch Vehicles by make
            System.out.println("Vehicles found with findByMake('Toyota')");
            System.out.println("---------------------------");
            for (Vehicle kia : vehicleRepository.findByMake("Kia")) {
                System.out.println(kia.toString());
            }
            System.out.println();
        };
    }
}
