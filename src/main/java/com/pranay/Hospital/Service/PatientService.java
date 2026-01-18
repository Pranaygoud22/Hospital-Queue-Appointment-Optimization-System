package com.pranay.Hospital.Service;

import com.pranay.Hospital.Model.Patient;
import com.pranay.Hospital.Repository.PatientRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    public PatientRespository patientRepo;

    public PatientService(PatientRespository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<Patient> getAllPatient(){
        return patientRepo.findAll();
    }
    public void registerPatient(Patient patient) {
        patientRepo.save(patient);
    }
}
