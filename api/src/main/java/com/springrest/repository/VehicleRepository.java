package com.springrest.repository;

import com.springrest.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    public Vehicle insertVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    public Vehicle getVehicleByVin(String vin);
    public List<Vehicle> getAllVehicle();
}
