package com.example.subscription_alertas.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VITAL_SIGNS")
public class VitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VITAL_SIGNS")
    private Long id;

    @Column(name = "IDPACIENTE", nullable = false)
    private Long idPaciente;

    @Column(name = "HEARTRATE", nullable = false)
    private Float heartRate;

    @Column(name = "BLOOD_PRESSURE", length = 10)
    private String bloodPressure; // Ejemplo: "120/80"

    @Column(name = "BODY_TEMPERATURE")
    private Float bodyTemperature;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Float heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Float getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
