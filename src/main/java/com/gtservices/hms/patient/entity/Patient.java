package com.gtservices.hms.patient.entity;

import com.gtservices.hms.appointment.entity.Appointment;
import com.gtservices.hms.billing.entity.entity.Payment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "patient_uid", unique = true, length = 20)
    private String patientUid;

    @Column(name = "patient_name", length = 100)
    private String patientName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "mobile_no", unique = true, length = 15)
    private String mobileNo;

    @Column(name = "alternate_mobile", length = 15)
    private String alternateMobile;

    @Column(name = "blood_group", length = 5)
    private String bloodGroup;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PatientVisit> visits;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Payment> payments;
}