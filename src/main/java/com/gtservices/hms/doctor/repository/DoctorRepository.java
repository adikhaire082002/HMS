package com.gtservices.hms.doctor.repository;

import com.gtservices.hms.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
