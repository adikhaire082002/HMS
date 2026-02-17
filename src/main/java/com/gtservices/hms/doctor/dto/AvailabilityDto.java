package com.gtservices.hms.doctor.dto;

import com.gtservices.hms.doctor.entity.DoctorAvailability;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class AvailabilityDto {
    private DoctorAvailability.DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
