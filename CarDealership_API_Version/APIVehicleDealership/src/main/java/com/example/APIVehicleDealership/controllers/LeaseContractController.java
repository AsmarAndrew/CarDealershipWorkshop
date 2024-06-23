package com.example.APIVehicleDealership.controllers;

import com.example.APIVehicleDealership.models.dtos.LeaseContractDTO;
import com.example.APIVehicleDealership.services.LeaseContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/leasecontracts")
public class LeaseContractController {

    @Autowired
    private LeaseContractService leaseContractService;

    @GetMapping("/{id}")
    public Optional<LeaseContractDTO> getLeaseContractById(@PathVariable int id) {
        return leaseContractService.getLeaseContractById(id);
    }

    @PostMapping
    public LeaseContractDTO addLeaseContract(@RequestBody LeaseContractDTO leaseContractDTO) {
        return leaseContractService.addLeaseContract(leaseContractDTO);
    }
}
