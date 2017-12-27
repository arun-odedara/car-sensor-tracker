package com.springrest.controller;

import com.springrest.entity.Reading;
import com.springrest.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST)
    public void insertReadings(@RequestBody Reading reading){
        readingService.insertReadings(reading);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Reading getReadingByVin(@PathVariable("vin") String vin){
        return readingService.getReadingByVin(vin);
    }
}
