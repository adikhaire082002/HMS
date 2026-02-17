package com.gtservices.hms.patient.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {

    private Integer patientId;
    private String patientUid;
    private String patientName;
    private Integer age;
    private String address;
    private String mobileNo;
    private String email;
    private String bloodGroup;
    private String bloodPressure;
    private Double weight;
    private LocalDateTime createdAt;
    private List<PatientFamilyDto> familyMembers;
}