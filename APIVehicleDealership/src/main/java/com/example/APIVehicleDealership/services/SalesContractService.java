package com.example.APIVehicleDealership.services;

import com.example.APIVehicleDealership.models.SalesContract;
import com.example.APIVehicleDealership.models.dtos.SalesContractDTO;
import com.example.APIVehicleDealership.models.mappers.SalesContractMapper;
import com.example.APIVehicleDealership.repositories.SalesContractRepository;
import com.example.APIVehicleDealership.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesContractService {

    @Autowired
    private SalesContractRepository salesContractRepository;

    public Optional<SalesContractDTO> getSalesContractById(int id) {
        SalesContract contract = salesContractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sales contract not found"));
        return Optional.of(SalesContractMapper.toDTO(contract));
    }

    public SalesContractDTO addSalesContract(SalesContractDTO salesContractDTO) {
        SalesContract salesContract = SalesContractMapper.toEntity(salesContractDTO);
        salesContractRepository.save(salesContract);
        return SalesContractMapper.toDTO(salesContract);
    }
}
