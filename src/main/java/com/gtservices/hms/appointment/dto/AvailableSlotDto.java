package com.gtservices.hms.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class AvailableSlotDto {

    private LocalTime time;
    private boolean available;
}
