package com.gtservices.hms.ipd.repository;

import com.gtservices.hms.ipd.entity.IpdAdmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPDRepository extends JpaRepository<IpdAdmission,Integer> {
}
