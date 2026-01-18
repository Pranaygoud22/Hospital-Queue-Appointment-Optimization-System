package com.pranay.Hospital.Controller;

import com.pranay.Hospital.Model.Doctor;
import com.pranay.Hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital/api/doctor")
public class DoctorController {

        @Autowired
        private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
        public void addDoctor(@RequestBody Doctor doctor)
        {
            doctorService.addDoctor(doctor);
        }

}
