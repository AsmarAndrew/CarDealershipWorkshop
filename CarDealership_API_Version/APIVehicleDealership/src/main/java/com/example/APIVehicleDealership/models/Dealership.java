package com.example.APIVehicleDealership.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "dealership")
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealership_id")
    private int dealershipId;

    private String name;
    private String address;
    private String phone;

}
