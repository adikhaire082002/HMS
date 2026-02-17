package com.gtservices.hms.patient.repository;

import com.gtservices.hms.patient.entity.PatientFamily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientFamilyRepository extends JpaRepository<PatientFamily, Integer> {
}
