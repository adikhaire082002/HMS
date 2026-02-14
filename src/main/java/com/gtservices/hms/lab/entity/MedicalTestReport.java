package com.gtservices.hms.lab.entity;

import com.gtservices.hms.appointment.entity.Appointment;
import com.gtservices.hms.consultation.entity.entity.Consultation;
import com.gtservices.hms.doctor.entity.entity.Doctor;
import com.gtservices.hms.patient.entity.Patient;
import com.gtservices.hms.enums.ReportStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "medical_test_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalTestReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_report_id")
    private Integer testReportId;

    @Column(name = "test_report_uid", unique = true, length = 25)
    private String testReportUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @Column(name = "test_name", nullable = false, length = 150)
    private String testName;

    @Column(name = "test_category", length = 100)
    private String testCategory;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referred_by_doctor")
    private Doctor referredByDoctor;

    @Column(name = "lab_name", length = 150)
    private String labName;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_status")
    private ReportStatus reportStatus;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}