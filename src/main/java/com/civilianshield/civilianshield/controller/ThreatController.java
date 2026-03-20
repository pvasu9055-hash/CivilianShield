package com.civilianshield.civilianshield.controller;

import com.civilianshield.civilianshield.model.Threat;
import com.civilianshield.civilianshield.repository.ThreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ThreatController {

    @Autowired
    private ThreatRepository threatRepository;

    @GetMapping("/api/threats")
    public List<Threat> getThreats() {
        return threatRepository.findAll();
    }

    @PostMapping("/api/threats/add")
    public Threat addThreat(@RequestBody Threat threat) {
        return threatRepository.save(threat);
    }

    @GetMapping("/api/threats/level")
    public Map<String, Object> getThreatLevel() {
        Map<String, Object> level = new HashMap<>();
        level.put("percentage", 42);
        level.put("status", "MODERATE");
        level.put("message", "Stay alert. 2 events nearby.");
        level.put("totalThreats", threatRepository.count());
        return level;
    }

    @DeleteMapping("/api/threats/{id}")
    public Map<String, Object> deleteThreat(@PathVariable Long id) {
        threatRepository.deleteById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "DELETED");
        response.put("id", id);
        return response;
    }
}