package com.gtservices.hms.insurance.entity;

import com.gtservices.hms.patient.entity.Patient;
import com.gtservices.hms.enums.ClaimStatus;

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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_claims")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Integer claimId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "policy_id")
    private Integer policyId;

    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "total_bill_amount", precision = 10, scale = 2)
    private BigDecimal totalBillAmount;

    @Column(name = "approved_amount", precision = 10, scale = 2)
    private BigDecimal approvedAmount;

    @Column(name = "patient_payable_amount", precision = 10, scale = 2)
    private BigDecimal patientPayableAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "claim_status")
    private ClaimStatus claimStatus;

    @Column(name = "claim_reference_no", length = 50)
    private String claimReferenceNo;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}