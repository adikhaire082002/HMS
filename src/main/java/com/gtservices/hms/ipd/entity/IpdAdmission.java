package com.gtservices.hms.ipd.entity;

import com.gtservices.hms.patient.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ipd_admissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpdAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    private Integer admissionId;

    @Column(name = "admission_uid", unique = true, length = 20)
    private String admissionUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @Column(name = "bed_type", length = 50)
    private String bedType;

    @Column(name = "ward_type", length = 50)
    private String wardType;

    @OneToMany(mappedBy = "admission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IpdCharge> charges;

    @OneToMany(mappedBy = "admission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IpdInvoice> invoices;
}