package com.habu.job_system.controller;

import com.habu.job_system.entity.Job;
import com.habu.job_system.repository.JobRepository;
import com.habu.job_system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobController {

    @Autowired
    private JobRepository repo;

    @Autowired
    private JobService service;

    @PostMapping("/post")
    public Job postJob(@RequestBody Job job) {

        job.setStatus("ACTIVE");

        Job saved = repo.save(job);

        service.processJob(saved); // 🔥 THREAD

        return saved;
    }

    @GetMapping("/company/{name}")
    public List<Job> getJobs(@PathVariable String name) {
        return repo.findByCompanyName(name);
    }
}