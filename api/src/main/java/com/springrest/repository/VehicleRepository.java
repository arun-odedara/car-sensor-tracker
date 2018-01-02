package com.springrest.repository;

import com.springrest.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    public void insertVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public Vehicle getVehicleByVin(String vin);
    public List<Vehicle> getAllVehicles();
}
