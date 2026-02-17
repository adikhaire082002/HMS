package com.gtservices.hms.patient.mapper;

import com.gtservices.hms.appointment.dto.AppointmentDto;
import com.gtservices.hms.appointment.dto.PatientAppointmentsDto;
import com.gtservices.hms.appointment.entity.Appointment;
import com.gtservices.hms.patient.dto.PatientFamilyDto;
import com.gtservices.hms.patient.dto.PatientResponseDto;
import com.gtservices.hms.patient.entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper
{
    public static PatientResponseDto mapToDTO(Patient patient) {

        PatientResponseDto dto = new PatientResponseDto();
        dto.setPatientId(patient.getPatientId());
        dto.setPatientName(patient.getPatientName());
        dto.setMobileNo(patient.getMobileNo());
        dto.setEmail(patient.getEmail());
        dto.setAge(patient.getAge());
        dto.setAddress(patient.getAddress());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setBloodPressure(patient.getBloodPressure());
        dto.setWeight(patient.getWeight());

        if (patient.getFamilyMembers() != null) {
            List<PatientFamilyDto> familyDtos = patient.getFamilyMembers().stream().map(f -> {
                PatientFamilyDto fdto = new PatientFamilyDto();
                fdto.setMemberName(f.getMemberName());
                fdto.setRelation(f.getRelation());
                fdto.setContactNo(f.getContactNo());
                return fdto;
            }).collect(Collectors.toList());
            dto.setFamilyMembers(familyDtos);
        }

        return dto;
    }

    public static AppointmentDto mapAppointmentToDTO(Appointment appt)
    {
        AppointmentDto dto = new AppointmentDto();

        dto.setAppointmentId(appt.getAppointmentId());
        dto.setDoctorName(appt.getDoctor().getDoctorName());
        dto.setAppointmentDate(appt.getAppointmentDate());
        dto.setAppointmentTime(appt.getAppointmentTime());
        dto.setAppointmentStatus(appt.getAppointmentStatus());

        return dto;
    }

    public static PatientAppointmentsDto mapToPatientAppointmentsDTO(Patient patient, List<Appointment> appointments) {
        List<AppointmentDto> appointmentDTOs = appointments.stream()
                .map(PatientMapper::mapAppointmentToDTO)
                .collect(Collectors.toList());

        PatientAppointmentsDto dto = new PatientAppointmentsDto();
        dto.setPatientId(patient.getPatientId());
        dto.setPatientName(patient.getPatientName());
        dto.setEmail(patient.getEmail());
        dto.setMobileNo(patient.getMobileNo());
        dto.setAppointments(appointmentDTOs);

        return dto;
    }
}
