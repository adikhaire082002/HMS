package com.gtservices.hms.doctor.dto;

import com.gtservices.hms.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DoctorRegistrationRequestDto {

    private String doctorName;
    private String guardianName;
    private String contactNo;
    private String emailId;
    private String address;
    private LocalDate dateOfBirth;
    private Integer age;
    private Gender gender;
    private BigDecimal consultationFees;
    private Boolean hasExperience;

    private String specializationName;

    private List<EducationDto> educations;
    private List<ExperienceDto> experiences;
    private List<AvailabilityDto> availabilities;
}
