package com.gtservices.hms.lab.repository;

import com.gtservices.hms.lab.entity.MedicalTestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository<MedicalTestReport, Integer> {
}
