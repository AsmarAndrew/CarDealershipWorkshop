package com.example.APIVehicleDealership.controllers;

import com.example.APIVehicleDealership.models.dtos.SalesContractDTO;
import com.example.APIVehicleDealership.services.SalesContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/salescontracts")
public class SalesContractController {

    @Autowired
    private SalesContractService salesContractService;

    @GetMapping("/{id}")
    public Optional<SalesContractDTO> getSalesContractById(@PathVariable int id) {
        return salesContractService.getSalesContractById(id);
    }

    @PostMapping
    public SalesContractDTO addSalesContract(@RequestBody SalesContractDTO salesContractDTO) {
        return salesContractService.addSalesContract(salesContractDTO);
    }
}
