package com.springrest.service;

import com.springrest.entity.Reading;
import com.springrest.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    public void insertReadings(Reading reading){
        readingRepository.insertReadings(reading);
    }

    public Reading getReadingByVin(String vin){
        return readingRepository.getReadingByVin(vin);
    }

    public List<Reading> getAllReadings() {
        return readingRepository.getAllReadings();
    }
}
