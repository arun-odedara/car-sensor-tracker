package com.springrest.service;

import com.springrest.entity.Reading;

import java.util.List;

public interface ReadingService {

    public void insertReadings(Reading reading);
    public Reading getReadingByVin(String vin);
    public List<Reading> getAllReadings();
}
