package com.exampl.repository;

import com.exampl.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel , Integer> {

    Optional<UserModel> findByMobileNumber( String mobileNo );
    boolean existsByMobileNumber( String mobileNo );
}
