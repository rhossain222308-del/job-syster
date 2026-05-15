package com.habu.job_system.controller;

import com.habu.job_system.entity.Application;
import com.habu.job_system.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@CrossOrigin
public class ApplicationController {

    @Autowired
    private ApplicationRepository repository;

    // APPLY JOB
    @PostMapping("/apply")
    public Application apply(@RequestBody Application app) {

        return repository.save(app);
    }

    // ALL APPLICATION
    @GetMapping("/all")
    public List<Application> all() {

        return repository.findAll();
    }

    // USER APPLICATION
    @GetMapping("/user/{email}")
    public List<Application> userApplications(
            @PathVariable String email) {

        return repository.findByUserEmail(email);
    }
}