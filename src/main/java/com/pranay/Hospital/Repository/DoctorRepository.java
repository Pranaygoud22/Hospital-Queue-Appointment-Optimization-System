package com.pranay.Hospital.Repository;

import com.pranay.Hospital.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
