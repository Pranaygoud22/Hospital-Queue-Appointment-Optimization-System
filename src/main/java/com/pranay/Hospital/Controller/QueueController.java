package com.pranay.Hospital.Controller;

import com.pranay.Hospital.Model.QueueEntry;
import com.pranay.Hospital.Repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hospital/api/queue")
public class QueueController {

    @Autowired
    private QueueRepository repo;

    @GetMapping("/status")
    public List<QueueEntry> getQueue() {
        return repo.findAllByOrderByPositionAsc();
    }
}