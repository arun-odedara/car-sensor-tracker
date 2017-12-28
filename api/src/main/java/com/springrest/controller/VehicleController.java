package com.springrest.controller;

import com.springrest.entity.Vehicle;
import com.springrest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT)
    public void insertVehicles(@RequestBody List<Vehicle> vehicle){
        vehicleService.insertVehicle(vehicle);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicle getVehicleByVin(@PathVariable("vin") String vin){
        return vehicleService.getVehicleByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getAllVehicle(){

        return vehicleService.getAllVehicle();
    }




}
