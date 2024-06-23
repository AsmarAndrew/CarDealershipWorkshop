package com.example.APIVehicleDealership.repositories;

import com.example.APIVehicleDealership.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findByDealershipId(int dealershipId);

    void deleteByVinAndDealershipId(String vin, int dealershipId);
}
