package com.springrest.repository;

import com.springrest.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
    public void insertVehicle(Vehicle vehicle) {
        
    }

    public Vehicle getVehicleByVin(String vin) {
        return null;
    }

    public List<Vehicle> getAllVehicle() {
        return null;
    }
}
