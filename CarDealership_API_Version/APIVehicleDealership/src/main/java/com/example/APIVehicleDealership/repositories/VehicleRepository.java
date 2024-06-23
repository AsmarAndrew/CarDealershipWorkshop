package com.example.APIVehicleDealership.repositories;

import com.example.APIVehicleDealership.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    List<Vehicle> findByVinInAndPriceBetween(List<String> vins, Double minPrice, Double maxPrice);

    List<Vehicle> findByVinInAndMakeAndModel(List<String> vins, String make, String model);

    List<Vehicle> findByVinInAndYearBetween(List<String> vins, Integer minYear, Integer maxYear);

    List<Vehicle> findByVinInAndColor(List<String> vins, String color);

    List<Vehicle> findByVinInAndOdometerBetween(List<String> vins, Double minMiles, Double maxMiles);

    List<Vehicle> findByVinInAndVehicleType(List<String> vins, String type);
}
