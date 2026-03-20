package com.civilianshield.civilianshield.repository;

import com.civilianshield.civilianshield.model.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreatRepository extends JpaRepository<Threat, Long> {
}