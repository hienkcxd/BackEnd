package com.example.BachEnd_Ses4.repositories.system;

import com.example.BachEnd_Ses4.model.System.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLogRepo extends JpaRepository<UserLog, Long> {
    @Query(value = "select u from UserLog u where u.username = ?1")
    public List<UserLog> findUserLogByUsername(String username);
}
