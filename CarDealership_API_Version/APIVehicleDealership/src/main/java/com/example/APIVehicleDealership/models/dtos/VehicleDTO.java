package com.example.APIVehicleDealership.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleDTO {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double odometer;
    private double price;

}
