package com.example.APIVehicleDealership.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "dealership_id")
    private int dealershipId;

    @ManyToOne
    @JoinColumn(name = "dealership_id", insertable = false, updatable = false)
    private Dealership dealership;

    @ManyToOne
    @JoinColumn(name = "vin", insertable = false, updatable = false)
    private Vehicle vehicle;

    public Inventory() {}

    public Inventory(String vin, int dealershipId) {
        this.vin = vin;
        this.dealershipId = dealershipId;
    }

}
