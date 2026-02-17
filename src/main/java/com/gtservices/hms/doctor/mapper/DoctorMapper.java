package com.gtservices.hms.doctor.mapper;

import com.gtservices.hms.doctor.dto.DoctorResponseDto;
import com.gtservices.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorResponseDto toResponse(Doctor doctor) {
        return DoctorResponseDto.builder()
                .doctorId(doctor.getDoctorId())
                .doctorName(doctor.getDoctorName())
                .doctorUid(doctor.getDoctorUid())
                .specializationName(
                        doctor.getSpecialization() != null ?
                                doctor.getSpecialization().getSpecializationName() : null)
                .contactNo(doctor.getContactNo())
                .emailId(doctor.getEmailId())
                .build();
    }
}

