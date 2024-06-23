package com.example.APIVehicleDealership.controllers;

import com.example.APIVehicleDealership.models.Dealership;
import com.example.APIVehicleDealership.services.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dealerships")
public class DealershipController {

    @Autowired
    private DealershipService dealershipService;

    @GetMapping
    public List<Dealership> getAllDealerships() {
        return dealershipService.getAllDealerships();
    }

    @GetMapping("/{id}")
    public Optional<Dealership> getDealershipById(@PathVariable int id) {
        return dealershipService.getDealershipById(id);
    }
}
