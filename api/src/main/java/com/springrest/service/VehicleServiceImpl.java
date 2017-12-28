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

    public void insertVehicle(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            Vehicle existing = vehicleRepository.getVehicleByVin(vehicle.getVin());
            if (existing == null) {
                vehicleRepository.insertVehicle(vehicle);
            } else {
                vehicleRepository.updateVehicle(vehicle);
            }
        }
    }

    public Vehicle getVehicleByVin(String vin) {
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        if(existing == null) {
            System.out.println("This vin number does not exist....!!");
        }
        return vehicleRepository.getVehicleByVin(vin);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.getAllVehicle();
    }
}
