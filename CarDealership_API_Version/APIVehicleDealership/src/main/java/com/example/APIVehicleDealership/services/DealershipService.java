package com.example.APIVehicleDealership.services;

import com.example.APIVehicleDealership.models.Dealership;
import com.example.APIVehicleDealership.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealershipService {

    @Autowired
    private DealershipRepository dealershipRepository;

    public List<Dealership> getAllDealerships() {
        return dealershipRepository.findAll();
    }

    public Optional<Dealership> getDealershipById(int id) {
        return dealershipRepository.findById(id);
    }
}
