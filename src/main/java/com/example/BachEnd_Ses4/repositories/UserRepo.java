package com.example.BachEnd_Ses4.repositories;

import com.example.BachEnd_Ses4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);

}
