package com.springrest.service;

import com.springrest.entity.Reading;
import com.springrest.entity.Vehicle;
import com.springrest.exception.ResourceNotFound;
import com.springrest.repository.ReadingRepository;
import com.springrest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public void insertReadings(Reading reading){
        Vehicle existing = vehicleRepository.getVehicleByVin(reading.getVin());
        if(existing == null){
            throw new ResourceNotFound("Reading for a Vehicle with vin: " + reading.getVin() + "Does not exist.");
        }else   readingRepository.insertReadings(reading);
    }

    public List<Reading> getReadingByVin(String vin){
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        if(existing == null) {
            throw new ResourceNotFound("The Vehicle with vin: " + vin + "does not exist.");
        }
        else return readingRepository.getReadingByVin(vin);
    }

    public List<Reading> getAllReadings() {
        return readingRepository.getAllReadings();
    }
}
