package com.gtservices.hms.patient.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PatientRequestDto {

    private String patientName;
    private Integer age;
    private String address;
    private String mobileNo;
    private String email;
    private String bloodGroup;
    private String bloodPressure;
    private Double weight;
    private List<PatientFamilyDto> familyMembers;

}
