package com.example.APIVehicleDealership.services;

import com.example.APIVehicleDealership.models.Vehicle;
import com.example.APIVehicleDealership.models.Inventory;
import com.example.APIVehicleDealership.models.dtos.VehicleDTO;
import com.example.APIVehicleDealership.models.mappers.VehicleMapper;
import com.example.APIVehicleDealership.repositories.VehicleRepository;
import com.example.APIVehicleDealership.repositories.InventoryRepository;
import com.example.APIVehicleDealership.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<VehicleDTO> getVehiclesByPrice(int dealershipId, Double minPrice, Double maxPrice) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndPriceBetween(vins, minPrice, maxPrice);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByMakeAndModel(int dealershipId, String make, String model) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndMakeAndModel(vins, make, model);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByYear(int dealershipId, Integer minYear, Integer maxYear) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndYearBetween(vins, minYear, maxYear);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByColor(int dealershipId, String color) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndColor(vins, color);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByOdometer(int dealershipId, Double minMiles, Double maxMiles) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndOdometerBetween(vins, minMiles, maxMiles);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> getVehiclesByType(int dealershipId, String type) {
        List<String> vins = getVehicleVinsByDealership(dealershipId);
        List<Vehicle> vehicles = vehicleRepository.findByVinInAndVehicleType(vins, type);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }

    public VehicleDTO addVehicleToDealership(int dealershipId, VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO);
        vehicleRepository.save(vehicle);
        inventoryRepository.save(new Inventory(vehicle.getVin(), dealershipId));
        return VehicleMapper.toDTO(vehicle);
    }

    public VehicleDTO updateVehicle(int dealershipId, String vin, VehicleDTO vehicleDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(vin).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        VehicleMapper.updateEntityFromDTO(existingVehicle, vehicleDTO);
        vehicleRepository.save(existingVehicle);
        return VehicleMapper.toDTO(existingVehicle);
    }

    public void deleteVehicle(int dealershipId, String vin) {
        Vehicle existingVehicle = vehicleRepository.findById(vin).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        inventoryRepository.deleteByVinAndDealershipId(vin, dealershipId);
        vehicleRepository.delete(existingVehicle);
    }

    private List<String> getVehicleVinsByDealership(int dealershipId) {
        return inventoryRepository.findByDealershipId(dealershipId).stream()
                .map(Inventory::getVin)
                .collect(Collectors.toList());
    }
}
