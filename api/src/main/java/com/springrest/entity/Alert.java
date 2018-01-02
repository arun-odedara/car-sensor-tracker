package com.springrest.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.getAlertByVin", query = "SELECT alert from Alert alert where alert.vin=:paramVin"),
        @NamedQuery(name = "Alert.getAllAlerts", query = "SELECT alert from Alert alert"),
})
public class Alert {

    @Id
    private String id;
    private String vin;
    private String priority;
    private String alertType;

//    @Embedded
//    private Reading reading;

    public String getId() {
        return id;
    }

    public Alert() {
        this.id = UUID.randomUUID().toString();
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

//    public Reading getReading() {
//        return reading;
//    }
//
//    public void setReading(Reading reading) {
//        this.reading = reading;
//    }
}
