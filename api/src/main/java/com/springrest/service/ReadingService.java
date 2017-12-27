package com.springrest.service;

import com.springrest.entity.Reading;

public interface ReadingService {

    public void insertReadings(Reading reading);
    public Reading getReadingByVin(String vin);
}
