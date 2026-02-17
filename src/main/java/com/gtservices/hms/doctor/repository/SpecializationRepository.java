package com.gtservices.hms.doctor.repository;

import com.gtservices.hms.doctor.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

    Optional<Specialization> findBySpecializationNameIgnoreCase(String name);
}
