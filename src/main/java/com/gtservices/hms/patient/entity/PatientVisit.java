package com.gtservices.hms.patient.entity;

import com.gtservices.hms.consultation.entity.entity.Consultation;
import com.gtservices.hms.enums.VisitStatus;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient_visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Integer visitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "visit_date")
    private LocalDateTime visitDate;

    @Column(name = "weight", precision = 5, scale = 2)
    private BigDecimal weight;

    @Column(name = "blood_pressure", length = 20)
    private String bloodPressure;

    @Column(name = "ped", length = 50)
    private String ped;

    @Column(name = "current_medication", columnDefinition = "TEXT")
    private String currentMedication;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_status")
    private VisitStatus visitStatus;

    @OneToMany(mappedBy = "visit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultation> consultations;
}