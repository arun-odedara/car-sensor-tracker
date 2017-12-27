package com.springrest.repository;

import com.springrest.entity.Reading;

public interface ReadingRepository {
    public void insertReadings(Reading reading);
    public Reading getReadingByVin(String vin);
}
