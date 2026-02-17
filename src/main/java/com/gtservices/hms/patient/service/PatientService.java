package com.gtservices.hms.patient.service;

import com.gtservices.hms.appointment.dto.PatientAppointmentsDto;
import com.gtservices.hms.patient.dto.PatientRequestDto;
import com.gtservices.hms.patient.dto.PatientResponseDto;

import java.util.List;

public interface PatientService
{
    PatientResponseDto registerPatient(PatientRequestDto dto);

    PatientAppointmentsDto getPatientAppointments(Integer patientId);

}
