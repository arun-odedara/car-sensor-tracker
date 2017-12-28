package com.springrest.service;

import com.springrest.entity.Vehicle;
import com.springrest.exception.ResourceNotFound;
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
            System.out.println(vehicle.toString());
            Vehicle existing = vehicleRepository.getVehicleByVin(vehicle.getVin());
            if (existing == null)
                vehicleRepository.insertVehicle(vehicle);
            else
                vehicleRepository.updateVehicle(vehicle);
        }
    }

    public Vehicle getVehicleByVin(String vin) {
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        if(existing == null) {
            throw new ResourceNotFound("The Vehicle with vin: "+vin + "does not exist.");
        }
        return vehicleRepository.getVehicleByVin(vin);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.getAllVehicle();
    }
}
