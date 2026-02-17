package com.gtservices.hms.patient.repository;

import com.gtservices.hms.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>
{

    Optional<Patient> findByMobileNo(String mobileNo);
    Optional<Patient>findByPatientId(Integer patientId);

    Optional<Patient> findByPatientUid(String patientUid);
}
