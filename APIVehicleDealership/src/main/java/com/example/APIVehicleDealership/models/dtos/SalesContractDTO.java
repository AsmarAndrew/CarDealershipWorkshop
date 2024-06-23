package com.example.APIVehicleDealership.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SalesContractDTO {
    private int salesId;
    private String vin;
    private Date contractDate;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private boolean financeOption;
    private double totalAmount;
    private int dealershipId;

}
