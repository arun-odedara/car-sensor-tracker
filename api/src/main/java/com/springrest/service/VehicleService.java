package com.springrest.service;

import com.springrest.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void insertVehicle(List<Vehicle> vehicle);
    public Vehicle getVehicleByVin(String vin);
    public List<Vehicle> getAllVehicle();
}
