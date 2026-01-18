package com.pranay.Hospital.Controller;

import com.pranay.Hospital.Model.Appointment;
import com.pranay.Hospital.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hospital/api/admin")
public class AdminController {

    @Autowired
    private AppointmentRepository repo;

    @GetMapping("/appointments/all")
    public List<Appointment> getAll() {
        return repo.findAll();
    }
}

