package com.pranay.Hospital.Service;

import com.pranay.Hospital.Model.Doctor;
import com.pranay.Hospital.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    public DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }
}
