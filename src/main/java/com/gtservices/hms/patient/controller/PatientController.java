package com.gtservices.hms.patient.controller;

import com.gtservices.hms.appointment.dto.PatientAppointmentsDto;
import com.gtservices.hms.patient.dto.PatientRequestDto;
import com.gtservices.hms.patient.dto.PatientResponseDto;
import com.gtservices.hms.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController
{
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDto> registerPatient(@RequestBody PatientRequestDto dto)
    {
        return ResponseEntity.ok(patientService.registerPatient(dto));
    }

    @GetMapping("/appointments/{patientId}")
    public ResponseEntity<PatientAppointmentsDto> getPatientAppointments(@PathVariable Integer patientId)
    {
        PatientAppointmentsDto dto = patientService.getPatientAppointments(patientId);
        if(dto == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

}
