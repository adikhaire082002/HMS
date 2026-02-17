package com.gtservices.hms.appointment.dto;

import com.gtservices.hms.enums.AppointmentStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto
{
    private Integer appointmentId;
    private String doctorName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus appointmentStatus;  // Use enum type
    private String reasonForVisit;
}
