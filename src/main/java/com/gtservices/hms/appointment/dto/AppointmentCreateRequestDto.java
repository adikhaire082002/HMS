package com.gtservices.hms.appointment.dto;

import com.gtservices.hms.enums.BookingSource;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentCreateRequestDto {

    @NotNull
    @Positive
    private Integer patientId;

    @NotNull
    @Positive
    private Integer doctorId;

    @NotNull
    @FutureOrPresent
    private LocalDate appointmentDate;

    @NotNull
    private LocalTime appointmentTime;

    @NotBlank
    @Size(max = 255)
    private String reasonForVisit;

    @NotNull
    private BookingSource bookingSource;
}