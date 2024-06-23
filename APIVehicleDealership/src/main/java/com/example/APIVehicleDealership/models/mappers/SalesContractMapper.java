package com.example.APIVehicleDealership.models.mappers;

import com.example.APIVehicleDealership.models.SalesContract;
import com.example.APIVehicleDealership.models.dtos.SalesContractDTO;

public class SalesContractMapper {
    public static SalesContractDTO toDTO(SalesContract salesContract) {
        SalesContractDTO dto = new SalesContractDTO();
        dto.setSalesId(salesContract.getSalesId());
        dto.setVin(salesContract.getVin());
        dto.setContractDate(salesContract.getContractDate());
        dto.setCustomerName(salesContract.getCustomerName());
        dto.setCustomerEmail(salesContract.getCustomerEmail());
        dto.setCustomerPhone(salesContract.getCustomerPhone());
        dto.setFinanceOption(salesContract.isFinanceOption());
        dto.setTotalAmount(salesContract.getTotalAmount());
        dto.setDealershipId(salesContract.getDealershipId());
        return dto;
    }

    public static SalesContract toEntity(SalesContractDTO dto) {
        SalesContract salesContract = new SalesContract();
        salesContract.setVin(dto.getVin());
        salesContract.setContractDate(dto.getContractDate());
        salesContract.setCustomerName(dto.getCustomerName());
        salesContract.setCustomerEmail(dto.getCustomerEmail());
        salesContract.setCustomerPhone(dto.getCustomerPhone());
        salesContract.setFinanceOption(dto.isFinanceOption());
        salesContract.setTotalAmount(dto.getTotalAmount());
        salesContract.setDealershipId(dto.getDealershipId());
        return salesContract;
    }
}
