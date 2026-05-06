package com.habu.job_system.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatsController {

    @GetMapping
    public Map<String, Object> getStats() {

        Map<String, Object> res = new HashMap<>();


        res.put("totalJobs", 24);
        res.put("accepted", 8);
        res.put("rejected", 3);

        return res;
    }
}