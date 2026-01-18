package com.pranay.Hospital.Controller;

import com.pranay.Hospital.Model.Patient;
import com.pranay.Hospital.Service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("hospital/api/patient")
public class PatientController {
    public PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }
    @PostMapping("/register")
    public void registerPatient(@RequestBody Patient patient)
    {
        patientService.registerPatient(patient);
    }
}
