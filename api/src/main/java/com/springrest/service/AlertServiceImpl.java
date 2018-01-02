package com.springrest.service;

import com.springrest.entity.Alert;
import com.springrest.entity.Reading;
import com.springrest.entity.Tires;
import com.springrest.entity.Vehicle;
import com.springrest.exception.ResourceNotFound;
import com.springrest.repository.AlertRepository;
import com.springrest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlertServiceImpl  implements AlertService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    EmailService emailService;

    public void engineRpmAlert(Reading reading) {

        String vin = reading.getVin();
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        double engineRpm = reading.getEngineRpm();
        double readLineRpm = existing.getRedlineRpm();
        if(engineRpm>readLineRpm){
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setPriority("HIGH");
            alert.setAlertType("ENGINE");
//            alert.setReading(reading);

            emailService.sendEmail(alert, "receiver@gmail.com");
            alertRepository.createAlert(alert);
        }
    }

    public void fuelVolumeAlert(Reading reading) {
        String vin = reading.getVin();
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        double fuelVolume = reading.getFuelVolume();
        double maxfuelVolume = existing.getMaxFuelVolume();
        if(fuelVolume < maxfuelVolume*.10){
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setPriority("MEDIUM");
            alert.setAlertType("FUEL");
//            alert.setReading(reading);
            alertRepository.createAlert(alert);
        }
    }

    public void tirePressureAlert(Reading reading){
        Tires tires = reading.getTires();
        com.fasterxml.jackson.databind.ObjectMapper m = new com.fasterxml.jackson.databind.ObjectMapper();
        Map<String,Object> prsr = m.convertValue(tires, Map.class);

        for(Map.Entry<String, Object> entry : prsr.entrySet()) {
            int pressure = Integer.parseInt(entry.getValue().toString());
            if(pressure < 32 || pressure > 36){
                Alert alert = new Alert();
                alert.setVin(reading.getVin());
                alert.setPriority("LOW");
                alert.setAlertType("TIRE PRESSURE");
//                alert.setReading(reading);

                alertRepository.createAlert(alert);
            }
        }
    }

    public void engineCoolantOrLightAlert(Reading reading) {
        if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
            Alert alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setPriority("LOW");
            alert.setAlertType("ENGINE");
//            alert.setReading(reading);

            alertRepository.createAlert(alert);
        }
    }



    public List<Alert> getAlertsByVin(String vin) {
        Vehicle existing = vehicleRepository.getVehicleByVin(vin);
        if(existing == null) {
            throw new ResourceNotFound("The Vehicle with vin: "+vin + "does not exist.");
        }
        return alertRepository.getAlertsByVin(vin);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.getAllAlerts();
    }

}
