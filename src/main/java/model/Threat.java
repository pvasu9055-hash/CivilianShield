package com.civilianshield.civilianshield.model;

import jakarta.persistence.*;

@Entity
@Table(name = "threats")
public class Threat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String severity;
    private String distance;
    private String location;
    private String time;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public String getDistance() { return distance; }
    public void setDistance(String distance) { this.distance = distance; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}