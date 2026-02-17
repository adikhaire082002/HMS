package com.gtservices.hms.patient.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientFamilyDto
{
    private String memberName;
    private String relation;
    private String contactNo;

}
