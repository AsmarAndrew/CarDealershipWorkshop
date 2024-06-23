package com.example.APIVehicleDealership.models.mappers;

import com.example.APIVehicleDealership.models.Vehicle;
import com.example.APIVehicleDealership.models.dtos.VehicleDTO;

public class VehicleMapper {
    public static VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setVin(vehicle.getVin());
        dto.setYear(vehicle.getYear());
        dto.setMake(vehicle.getMake());
        dto.setModel(vehicle.getModel());
        dto.setVehicleType(vehicle.getVehicleType());
        dto.setColor(vehicle.getColor());
        dto.setOdometer(vehicle.getOdometer());
        dto.setPrice(vehicle.getPrice());
        return dto;
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(dto.getVin());
        vehicle.setYear(dto.getYear());
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setColor(dto.getColor());
        vehicle.setOdometer(dto.getOdometer());
        vehicle.setPrice(dto.getPrice());
        return vehicle;
    }

    public static void updateEntityFromDTO(Vehicle vehicle, VehicleDTO dto) {
        vehicle.setYear(dto.getYear());
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setColor(dto.getColor());
        vehicle.setOdometer(dto.getOdometer());
        vehicle.setPrice(dto.getPrice());
    }
}
