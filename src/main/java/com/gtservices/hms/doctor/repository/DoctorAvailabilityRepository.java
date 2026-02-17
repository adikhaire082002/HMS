package com.gtservices.hms.doctor.repository;

import com.gtservices.hms.doctor.entity.Doctor;
import com.gtservices.hms.doctor.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Integer> {

    Optional<DoctorAvailability> findByDoctorAndDayOfWeek(
            Doctor doctor,
            DoctorAvailability.DayOfWeek dayOfWeek
    );
}
