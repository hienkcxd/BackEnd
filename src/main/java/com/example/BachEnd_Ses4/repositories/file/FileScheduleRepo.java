package com.example.BachEnd_Ses4.repositories.file;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileScheduleRepo extends JpaRepository<FileSchedule, Long> {
}
