package com.gtservices.hms.patient.repository;

import com.gtservices.hms.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
