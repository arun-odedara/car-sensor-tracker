package com.springrest.repository;

import com.springrest.entity.Alert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void createAlert(Alert alert) {
        entityManager.persist(alert);
        entityManager.close();
    }

    public List<Alert> getAlertsByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.getAlertByVin", Alert.class);
        query.setParameter("paramVin", vin);
        return query.getResultList();
    }

    public List<Alert> getAllAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.getAllAlerts", Alert.class);
        return query.getResultList();
    }



}
