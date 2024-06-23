package com.example.APIVehicleDealership.controllers;

import com.example.APIVehicleDealership.models.dtos.VehicleDTO;
import com.example.APIVehicleDealership.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealerships/{dealershipId}/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/price")
    public List<VehicleDTO> getVehiclesByPrice(
            @PathVariable int dealershipId,
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return vehicleService.getVehiclesByPrice(dealershipId, minPrice, maxPrice);
    }

    @GetMapping("/make-model")
    public List<VehicleDTO> getVehiclesByMakeAndModel(
            @PathVariable int dealershipId,
            @RequestParam String make,
            @RequestParam String model) {

        return vehicleService.getVehiclesByMakeAndModel(dealershipId, make, model);
    }

    @GetMapping("/year")
    public List<VehicleDTO> getVehiclesByYear(
            @PathVariable int dealershipId,
            @RequestParam Integer minYear,
            @RequestParam Integer maxYear) {

        return vehicleService.getVehiclesByYear(dealershipId, minYear, maxYear);
    }

    @GetMapping("/color")
    public List<VehicleDTO> getVehiclesByColor(
            @PathVariable int dealershipId,
            @RequestParam String color) {

        return vehicleService.getVehiclesByColor(dealershipId, color);
    }

    @GetMapping("/odometer")
    public List<VehicleDTO> getVehiclesByOdometer(
            @PathVariable int dealershipId,
            @RequestParam Double minMiles,
            @RequestParam Double maxMiles) {

        return vehicleService.getVehiclesByOdometer(dealershipId, minMiles, maxMiles);
    }

    @GetMapping("/type")
    public List<VehicleDTO> getVehiclesByType(
            @PathVariable int dealershipId,
            @RequestParam String type) {

        return vehicleService.getVehiclesByType(dealershipId, type);
    }

    @PostMapping
    public VehicleDTO addVehicleToDealership(@PathVariable int dealershipId, @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.addVehicleToDealership(dealershipId, vehicleDTO);
    }

    @PutMapping("/{vin}")
    public VehicleDTO updateVehicle(@PathVariable int dealershipId, @PathVariable String vin, @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.updateVehicle(dealershipId, vin, vehicleDTO);
    }

    @DeleteMapping("/{vin}")
    public void deleteVehicle(@PathVariable int dealershipId, @PathVariable String vin) {
        vehicleService.deleteVehicle(dealershipId, vin);
    }
}