package com.exampl.repository;

import com.exampl.model.Role;
import com.exampl.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Integer> {

    Optional<Role> findByRole(String role);
}
