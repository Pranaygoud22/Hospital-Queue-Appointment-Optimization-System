package com.pranay.Hospital.Repository;

import com.pranay.Hospital.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor_IdAndDate(Long doctorId, LocalDate date);
}
