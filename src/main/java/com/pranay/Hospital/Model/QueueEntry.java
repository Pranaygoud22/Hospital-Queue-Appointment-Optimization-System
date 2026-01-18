package com.pranay.Hospital.Model;

import com.pranay.Hospital.Repository.DoctorRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class QueueEntry {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Appointment appointment;

    private int position;

    public QueueEntry(Long id, Appointment appointment, int position) {
        this.id = id;
        this.appointment = appointment;
        this.position = position;
    }

    public QueueEntry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
