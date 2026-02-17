package com.gtservices.hms.doctor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DoctorResponseDto {

    private Integer doctorId;
    private String doctorName;
    private String specializationName;
    private String doctorUid;
    private String contactNo;
    private String emailId;
}
