package com.gtservices.hms.patient.serviceImpl;

import com.gtservices.hms.appointment.dto.AppointmentDto;
import com.gtservices.hms.appointment.dto.AppointmentResponseDto;
import com.gtservices.hms.appointment.dto.PatientAppointmentsDto;
import com.gtservices.hms.appointment.repository.AppointmentRepository;
import com.gtservices.hms.patient.dto.PatientRequestDto;
import com.gtservices.hms.patient.dto.PatientResponseDto;
import com.gtservices.hms.patient.entity.Patient;
import com.gtservices.hms.patient.entity.PatientFamily;
import com.gtservices.hms.patient.mapper.PatientMapper;
import com.gtservices.hms.patient.repository.PatientRepository;
import com.gtservices.hms.patient.service.PatientService;
import com.gtservices.hms.patient.utility.UIDGenerator;
import com.gtservices.hms.user.entity.Role;
import com.gtservices.hms.user.entity.User;
import com.gtservices.hms.user.repository.RoleRepository;
import com.gtservices.hms.user.repository.UserRepository;
import lombok.*;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService
{
    private final PatientRepository patientRepository;

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public PatientResponseDto registerPatient(PatientRequestDto dto)
    {
        if(patientRepository.findByMobileNo(dto.getMobileNo()).isPresent())
        {
            throw new RuntimeException("Patient Already Exist");
        }

        User user = new User();

        Role patientRole = roleRepository.findByRoleName("PATIENT")
                .orElseThrow(() -> new RuntimeException("PATIENT role not found"));

        Patient patient = new Patient();
        patient.setPatientUid(UIDGenerator.generatePatientUID());
        patient.setPatientName(dto.getPatientName());
        patient.setMobileNo(dto.getMobileNo());
        patient.setEmail(dto.getEmail());
        patient.setAge(dto.getAge());
        patient.setAddress(dto.getAddress());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setBloodPressure(dto.getBloodPressure());
        patient.setWeight(dto.getWeight());
        patient.setUser(user);
        patient.setCreatedAt(LocalDateTime.now());

        user.setFullName(dto.getPatientName());
        user.setMobileNo(dto.getMobileNo());
        user.setEmail(dto.getEmail());

        // Manual password encoder (no bean required)
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPasswordHash(encoder.encode("12345"));
        user.setPasswordHash("123456");

        user.setRole(patientRole);
        user.setIsActive(true);
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        patient.setUser(savedUser);

        Patient savedPatient = patientRepository.save(patient);

        // Save family members
        if(dto.getFamilyMembers() != null && !dto.getFamilyMembers().isEmpty()) {
            List<PatientFamily> familyList = dto.getFamilyMembers().stream().map(f -> {
                PatientFamily family = new PatientFamily();
                family.setMemberName(f.getMemberName());
                family.setRelation(f.getRelation());
                family.setContactNo(f.getContactNo());
                family.setPatient(savedPatient); // set parent reference
                return family;
            }).collect(Collectors.toList());

            savedPatient.setFamilyMembers(familyList);
            patientRepository.save(savedPatient);
        }


        return PatientMapper.mapToDTO(savedPatient);

    }

    @Override
    public PatientAppointmentsDto getPatientAppointments(Integer patientId) {

        if(patientId == null)
        {
            throw new IllegalArgumentException("Patient ID must not be  null");
        }
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new RuntimeException("Patient not found with ID: " + patientId));

<<<<<<< HEAD
        List<AppointmentDto> appointmentDTOs = appointmentRepository.findAppointmentsWithDoctorByPatientId(patientId)
                .stream()
                .map(a -> {
                    AppointmentDto dto = new AppointmentDto();
                    dto.setAppointmentId(a.getAppointmentId());
                    dto.setDoctorName(a.getDoctor().getDoctorName());
                    dto.setAppointmentDate(a.getAppointmentDate());
                    dto.setAppointmentTime(a.getAppointmentTime());
                    dto.setAppointmentStatus(a.getAppointmentStatus());
                    dto.setReasonForVisit(a.getReasonForVisit());
                    return dto;
                }).collect(Collectors.toList());
=======
//        List<AppointmentDto> appointmentDTOs = appointmentRepository.findAppointmentsWithDoctorByPatientId(patientId)
//                .stream()
//                .map(a -> {
//                    AppointmentResponseDto dto = new AppointmentResponseDto();
//                    dto.setAppointmentId(a.getAppointmentId());
//                    dto.setDoctorName(a.getDoctor().getDoctorName());
//                    dto.setAppointmentDate(a.getAppointmentDate());
//                    dto.setAppointmentTime(a.getAppointmentTime());
//                    dto.setAppointmentStatus(String.valueOf(a.getAppointmentStatus()));
//                    dto.setReasonForVisit(a.getReasonForVisit());
//                    return dto;
//                }).collect(Collectors.toList());
>>>>>>> 7eff6b9 (added get appointments by status and id)

        PatientAppointmentsDto dto = new PatientAppointmentsDto();
        dto.setPatientId(patient.getPatientId());
        dto.setPatientName(patient.getPatientName());
        dto.setEmail(patient.getEmail());
        dto.setMobileNo(patient.getMobileNo());
//        dto.setAppointments(appointmentDTOs);

        return dto;

    }

}
