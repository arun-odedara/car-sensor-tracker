package com.springrest.repository;

import com.springrest.entity.Reading;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager em;

    public Reading insertReadings(Reading reading) {
        em.persist(reading);
        return reading;
    }

    public Reading getReadingByVin(String vin) {
        TypedQuery<Reading> query = em.createNamedQuery("Reading.getReadingByVin", Reading.class);
        query.setParameter("paramVin", vin);
        return query.getSingleResult();
    }

    public List<Reading> getAllReadings(){
        TypedQuery<Reading> query = em.createNamedQuery("Reading.getAllReadings", Reading.class);
        return query.getResultList();
    }
}
