package com.example.BachEnd_Ses4.repositories;

import com.example.BachEnd_Ses4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
