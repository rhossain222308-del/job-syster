package com.habu.job_system.controller;

import com.habu.job_system.entity.Company;
import com.habu.job_system.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyAuthController {

    @Autowired
    private CompanyRepository repo;

    // =====================
    // REGISTER
    // =====================
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Company c) {

        Map<String, Object> res = new HashMap<>();

        if (repo.findByEmail(c.getEmail()).isPresent()) {
            res.put("status", "error");
            res.put("message", "Email already exists");
            return res;
        }

        Company saved = repo.save(c);

        res.put("status", "success");
        res.put("message", "Company registered");
        res.put("company", saved);

        return res;
    }

    // =====================
    // LOGIN
    // =====================
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Company c) {

        Map<String, Object> res = new HashMap<>();

        Optional<Company> db = repo.findByEmail(c.getEmail());

        if (db.isPresent() &&
                db.get().getPassword().equals(c.getPassword())) {

            res.put("status", "success");
            res.put("company", db.get());

        } else {
            res.put("status", "error");
            res.put("message", "Invalid email or password");
        }

        return res;
    }
}