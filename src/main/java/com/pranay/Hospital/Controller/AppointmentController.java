package com.pranay.Hospital.Controller;

import com.pranay.Hospital.Model.*;
import com.pranay.Hospital.Repository.AppointmentRepository;
import com.pranay.Hospital.Repository.DoctorRepository;
import com.pranay.Hospital.Repository.PatientRespository;
import com.pranay.Hospital.Repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("hospital/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repo;
    @Autowired
    private PatientRespository patientRepo;
    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private QueueRepository queueRepo;

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody AppointmentDTO dto) {
        Optional<Patient> p = patientRepo.findById(dto.getPatientId());
        Optional<Doctor> d = doctorRepo.findById(dto.getDoctorId());
        System.out.println("Received Patient ID: " + dto.getPatientId());
        System.out.println("Received Doctor ID: " + dto.getDoctorId());
        System.out.println("Patient found: " + p.isPresent());
        System.out.println("Doctor found: " + d.isPresent());


        if (p.isEmpty() || d.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient or Doctor not found");

        Appointment appt = new Appointment();
        appt.setPatient(p.get());
        appt.setDoctor(d.get());
        appt.setDate(LocalDate.parse(dto.getDate()));
        appt.setTime(LocalTime.parse(dto.getTime()));
        appt.setStatus("Scheduled");
        appt = repo.save(appt);

        Integer position = queueRepo.countByDoctor(d.get()) + 1;
        QueueEntry qe = new QueueEntry();
        //qe.setPatient(p.get());
        //qe.setDoctor(d.get());
        qe.setPosition(position);
        qe.setAppointment(appt);
        queueRepo.save(qe);

        repo.save(appt);
        return ResponseEntity.ok(appt);
    }
    @GetMapping("/available-slots")
    public ResponseEntity<List<LocalTime>> getSlots(@RequestParam Long doctorId) {
        List<Appointment> booked = repo.findByDoctor_IdAndDate(doctorId, LocalDate.now());
        List<LocalTime> allSlots = IntStream.range(9, 17) // 9 AM to 4 PM
                .mapToObj(i -> LocalTime.of(i, 0))
                .collect(Collectors.toList());

        List<LocalTime> bookedTimes = booked.stream().map(Appointment::getTime).toList();
        List<LocalTime> available = allSlots.stream()
                .filter(time -> !bookedTimes.contains(time))
                .collect(Collectors.toList());

        return ResponseEntity.ok(available);
    }
    @PutMapping("/reschedule")
    public ResponseEntity<?> reschedule(@RequestParam Long appointmentId,
                                        @RequestParam String newDate,
                                        @RequestParam String newTime) {
        Optional<Appointment> opt = repo.findById(appointmentId);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Appointment a = opt.get();
        a.setDate(LocalDate.parse(newDate));
        a.setTime(LocalTime.parse(newTime));
        a.setStatus("Rescheduled");

        repo.save(a);
        return ResponseEntity.ok(a);
    }


}
