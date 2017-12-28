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

    public Vehicle insertVehicle(Vehicle vehicle) {
        em.persist(vehicle);
        return  vehicle;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        em.merge(vehicle);
        return  vehicle;
    }

    public Vehicle getVehicleByVin(String vin) {
//        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.getVehicleByVin", Vehicle.class);
//        query.setParameter("paramEmail", vin);
//        return query.getSingleResult();

        return em.find(Vehicle.class, vin);
    }

    public List<Vehicle> getAllVehicle() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.getAllVehicles", Vehicle.class);
        return query.getResultList();
    }
}
