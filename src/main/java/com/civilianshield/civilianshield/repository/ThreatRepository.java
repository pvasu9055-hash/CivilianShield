package com.civilianshield.civilianshield.repository;

import com.civilianshield.civilianshield.model.Threat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatRepository extends JpaRepository<Threat, Long> {
}