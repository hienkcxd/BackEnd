package com.example.BachEnd_Ses4.repositories.system;

import com.example.BachEnd_Ses4.model.System.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLogRepo extends JpaRepository<UserLog, Long> {
    public List<UserLog> findUserLogByUsername(String username);
}
