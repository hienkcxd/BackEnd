package com.example.BachEnd_Ses4.repositories.file;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileScheduleRepo extends JpaRepository<FileSchedule, Long> {
    public List<FileSchedule> findByUserName(String username);
}
