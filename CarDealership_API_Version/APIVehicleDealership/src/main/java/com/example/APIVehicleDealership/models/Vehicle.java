package com.example.APIVehicleDealership.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @Column(name = "vin")
    private String vin;

    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double odometer;
    private double price;

}
