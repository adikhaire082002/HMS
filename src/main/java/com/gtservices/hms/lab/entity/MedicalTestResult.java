package com.gtservices.hms.lab.entity;

import com.gtservices.hms.enums.ResultFlag;

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

@Entity
@Table(name = "medical_test_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_report_id", nullable = false)
    private MedicalTestReport testReport;

    @Column(name = "parameter_name", nullable = false, length = 100)
    private String parameterName;

    @Column(name = "result_value", length = 100)
    private String resultValue;

    @Column(name = "unit", length = 50)
    private String unit;

    @Column(name = "normal_range", length = 50)
    private String normalRange;

    @Enumerated(EnumType.STRING)
    @Column(name = "result_flag")
    private ResultFlag resultFlag;
}