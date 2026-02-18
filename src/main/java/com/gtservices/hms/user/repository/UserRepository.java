package com.gtservices.hms.user.repository;

import com.gtservices.hms.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByMobileNo(String mobileNo);
    boolean existsByEmail(String email);
}
