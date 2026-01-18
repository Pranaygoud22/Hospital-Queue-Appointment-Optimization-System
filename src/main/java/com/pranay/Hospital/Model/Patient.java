package com.pranay.Hospital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private String patientEmail;
    private String patientPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public Patient() {
    }

    public Patient(Long id, String patientName, String patientEmail, String patientPhone) {
        this.id = id;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.patientPhone = patientPhone;
    }
}
