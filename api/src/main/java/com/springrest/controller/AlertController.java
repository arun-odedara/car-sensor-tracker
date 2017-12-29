package com.springrest.controller;

import com.springrest.entity.Alert;
import com.springrest.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Alert> getAlertsByVin(@PathVariable("vin") String vin){
        return alertService.getAlertsByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> getAllAlerts(){
        return alertService.getAllAlerts();
    }
}
