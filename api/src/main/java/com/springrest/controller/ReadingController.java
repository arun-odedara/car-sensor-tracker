package com.springrest.controller;

import com.springrest.entity.Reading;
import com.springrest.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io")
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
    public List<Reading> getReadingsByVin(@PathVariable("vin") String vin){
        return readingService.getReadingsByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> getAllReadings(){
        return  readingService.getAllReadings();
    }
}
