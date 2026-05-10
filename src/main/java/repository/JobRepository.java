package com.habu.job_system.repository;

import com.habu.job_system.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyName(String companyName);
}