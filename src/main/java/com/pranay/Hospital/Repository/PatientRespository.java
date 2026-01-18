package com.pranay.Hospital.Repository;

import com.pranay.Hospital.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRespository extends JpaRepository<Patient, Long> {
}
