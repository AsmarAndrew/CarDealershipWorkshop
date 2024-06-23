package com.example.APIVehicleDealership.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LeaseContractDTO {
    private int leaseId;
    private String vin;
    private Date startDate;
    private Date endDate;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private double monthlyPayment;
    private double totalAmount;
    private int dealershipId;

}
