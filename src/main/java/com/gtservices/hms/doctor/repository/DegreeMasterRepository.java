package com.gtservices.hms.doctor.repository;

import com.gtservices.hms.doctor.entity.DegreeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DegreeMasterRepository extends JpaRepository<DegreeMaster, Integer> {

    Optional<DegreeMaster> findByDegreeNameIgnoreCase(String name);
}

