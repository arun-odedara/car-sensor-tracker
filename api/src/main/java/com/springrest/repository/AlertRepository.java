package com.springrest.repository;

import com.springrest.entity.Alert;

import java.util.List;

public interface AlertRepository {
    public void createAlert(Alert alert);
    public List<Alert> getAlertsByVin(String vin);
    public List<Alert> getAllAlerts();
}
