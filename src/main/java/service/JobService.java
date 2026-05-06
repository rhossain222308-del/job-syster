package com.habu.job_system.service;

import com.habu.job_system.entity.Job;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Async
    public void processJob(Job job) {

        System.out.println("🔥 Processing job: " + job.getTitle());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Done: " + job.getTitle());
    }
}