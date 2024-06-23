package com.example.APIVehicleDealership.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "lease_contract")
public class LeaseContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaseId;

    @Column(name = "vin")
    private String vin;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private double monthlyPayment;
    private double totalAmount;

    @Column(name = "dealership_id")
    private int dealershipId;

    @ManyToOne
    @JoinColumn(name = "vin", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealership_id", insertable = false, updatable = false)
    private Dealership dealership;

}
