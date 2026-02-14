package com.gtservices.hms.report.repository;

import com.gtservices.hms.report.entity.PatientReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientReportRepository extends JpaRepository<PatientReport, Integer> {
}
