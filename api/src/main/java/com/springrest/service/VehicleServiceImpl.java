package com.springrest.service;

import com.springrest.entity.Vehicle;
import com.springrest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    public void insertVehicle(Vehicle vehicle) {
        vehicleRepository.insertVehicle(vehicle);
    }

    public Vehicle getVehicleByVin(String vin) {
        return vehicleRepository.getVehicleByVin(vin);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.getAllVehicle();
    }
}
