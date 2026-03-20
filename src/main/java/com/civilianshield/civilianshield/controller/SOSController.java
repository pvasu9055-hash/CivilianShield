package com.civilianshield.civilianshield.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class SOSController {

    @PostMapping("/api/sos")
    public Map<String, Object> sendSOS(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SOS_SENT");
        response.put("message", "🆘 Alert sent to NDRF, Red Cross and Police!");
        response.put("location", request.get("location"));
        response.put("name", request.get("name"));
        response.put("caseId", "SOS" + (int)(Math.random() * 999999));
        response.put("timestamp", new Date().toString());
        response.put("respondersNotified", Arrays.asList("NDRF", "Red Cross India", "Local Police", "Family"));
        return response;
    }

    @GetMapping("/api/sos/status")
    public Map<String, Object> sosStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("activeSOSCases", 3);
        status.put("respondersOnline", 142);
        status.put("averageResponseTime", "4 minutes");
        status.put("systemStatus", "OPERATIONAL");
        return status;
    }
}