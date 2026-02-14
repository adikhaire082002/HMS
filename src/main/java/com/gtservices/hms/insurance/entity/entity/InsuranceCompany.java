package com.gtservices.hms.insurance.entity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insurance_companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_company_id")
    private Integer insuranceCompanyId;

    @Column(name = "company_name", nullable = false, unique = true, length = 100)
    private String companyName;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;
}