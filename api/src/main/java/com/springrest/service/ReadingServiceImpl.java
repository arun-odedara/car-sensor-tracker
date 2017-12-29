package com.springrest.service;

import com.springrest.entity.Alert;
import com.springrest.entity.Reading;
import com.springrest.entity.Vehicle;
import com.springrest.exception.ResourceNotFound;
import com.springrest.repository.ReadingRepository;
import com.springrest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AlertService alertService;

    public void insertReadings(Reading reading){
        Vehicle existing = vehicleRepository.getVehicleByVin(reading.getVin());
        if(existing == null){
            throw new ResourceNotFound("Readings for a Vehicle with vin: " + reading.getVin() + "Does not exist.");
        }else{
            alertService.engineRpmAlert(reading);
            alertService.tirePressureAlert(reading);
            alertService.fuelVolumeAlert(reading);
            alertService.engineCoolantOrLightAlert(reading);
            readingRepository.insertReadings(reading);
        }
    }

    public List<Reading> getReadingsByVin(String vin){
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        if(existing == null) {
            throw new ResourceNotFound("A Vehicle with vin: " + vin + "does not exist.");
        }
        else return readingRepository.getReadingsByVin(vin);
    }

    public List<Reading> getAllReadings() {
        return readingRepository.getAllReadings();
    }
}
