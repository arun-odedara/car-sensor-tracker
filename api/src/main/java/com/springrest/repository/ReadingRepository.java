package com.springrest.repository;

import com.springrest.entity.Reading;

import java.util.List;

public interface ReadingRepository {
    public Reading insertReadings(Reading reading);
    public Reading getReadingByVin(String vin);
    public List<Reading> getAllReadings();
}
