package com.gtservices.hms.ipd.entity;

import com.gtservices.hms.enums.ChargeType;

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

@Entity
@Table(name = "ipd_charges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpdCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charge_id")
    private Integer chargeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id")
    private IpdAdmission admission;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type")
    private ChargeType chargeType;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;
}