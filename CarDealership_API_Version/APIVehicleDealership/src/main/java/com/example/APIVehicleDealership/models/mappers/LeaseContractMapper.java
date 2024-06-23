package com.example.APIVehicleDealership.models.mappers;

import com.example.APIVehicleDealership.models.LeaseContract;
import com.example.APIVehicleDealership.models.dtos.LeaseContractDTO;

public class LeaseContractMapper {
    public static LeaseContractDTO toDTO(LeaseContract leaseContract) {
        LeaseContractDTO dto = new LeaseContractDTO();
        dto.setLeaseId(leaseContract.getLeaseId());
        dto.setVin(leaseContract.getVin());
        dto.setStartDate(leaseContract.getStartDate());
        dto.setEndDate(leaseContract.getEndDate());
        dto.setCustomerName(leaseContract.getCustomerName());
        dto.setCustomerEmail(leaseContract.getCustomerEmail());
        dto.setCustomerPhone(leaseContract.getCustomerPhone());
        dto.setMonthlyPayment(leaseContract.getMonthlyPayment());
        dto.setTotalAmount(leaseContract.getTotalAmount());
        dto.setDealershipId(leaseContract.getDealershipId());
        return dto;
    }

    public static LeaseContract toEntity(LeaseContractDTO dto) {
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setVin(dto.getVin());
        leaseContract.setStartDate(dto.getStartDate());
        leaseContract.setEndDate(dto.getEndDate());
        leaseContract.setCustomerName(dto.getCustomerName());
        leaseContract.setCustomerEmail(dto.getCustomerEmail());
        leaseContract.setCustomerPhone(dto.getCustomerPhone());
        leaseContract.setMonthlyPayment(dto.getMonthlyPayment());
        leaseContract.setTotalAmount(dto.getTotalAmount());
        leaseContract.setDealershipId(dto.getDealershipId());
        return leaseContract;
    }
}
