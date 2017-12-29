package com.springrest.service;

import com.springrest.entity.Alert;
import com.springrest.entity.Reading;

import java.util.List;

public interface AlertService {
    public void engineRpmAlert(Reading reading);
    public void fuelVolumeAlert(Reading reading);
    public void tirePressureAlert(Reading reading);
    public void engineCoolantOrLightAlert(Reading reading);

    public List<Alert> getAlertsByVin(String vin);
    public List<Alert> getAllAlerts();
}
