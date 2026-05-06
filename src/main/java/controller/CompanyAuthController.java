package com.habu.job_system.controller;

import com.habu.job_system.entity.Company;
import com.habu.job_system.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyAuthController {

    @Autowired
    private CompanyRepository repo;

    @PostMapping("/register")
    public String register(@RequestBody Company c) {
        repo.save(c);
        return "Company registered";
    }

    @PostMapping("/login")
    public Company login(@RequestBody Company c) {

        Optional<Company> db = repo.findByEmail(c.getEmail());

        if(db.isPresent() && db.get().getPassword().equals(c.getPassword())) {
            return db.get();
        }
        return null;
    }
}