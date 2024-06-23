package com.example.APIVehicleDealership.services;

import com.example.APIVehicleDealership.models.LeaseContract;
import com.example.APIVehicleDealership.models.dtos.LeaseContractDTO;
import com.example.APIVehicleDealership.models.mappers.LeaseContractMapper;
import com.example.APIVehicleDealership.repositories.LeaseContractRepository;
import com.example.APIVehicleDealership.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaseContractService {

    @Autowired
    private LeaseContractRepository leaseContractRepository;

    public Optional<LeaseContractDTO> getLeaseContractById(int id) {
        LeaseContract contract = leaseContractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lease contract not found"));
        return Optional.of(LeaseContractMapper.toDTO(contract));
    }

    public LeaseContractDTO addLeaseContract(LeaseContractDTO leaseContractDTO) {
        LeaseContract leaseContract = LeaseContractMapper.toEntity(leaseContractDTO);
        leaseContractRepository.save(leaseContract);
        return LeaseContractMapper.toDTO(leaseContract);
    }
}
