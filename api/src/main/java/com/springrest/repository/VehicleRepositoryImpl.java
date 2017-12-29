package com.springrest.repository;

import com.springrest.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    public void insertVehicle(Vehicle vehicle) {
        em.persist(vehicle);
        em.close();
    }

    public void updateVehicle(Vehicle vehicle) {
        em.merge(vehicle);
        em.close();
    }

    public Vehicle getVehicleByVin(String vin) {
        return em.find(Vehicle.class, vin);
    }

    public List<Vehicle> getAllVehicles() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.getAllVehicles", Vehicle.class);
        return query.getResultList();
    }
}
