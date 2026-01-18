package com.pranay.Hospital.Repository;

import com.pranay.Hospital.Model.Doctor;
import com.pranay.Hospital.Model.QueueEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository  extends JpaRepository<QueueEntry, Long> {
    List<QueueEntry> findAllByOrderByPositionAsc();
    Integer countByDoctor(Doctor doctor);
}
