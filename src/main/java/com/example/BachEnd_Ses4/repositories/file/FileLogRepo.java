package com.example.BachEnd_Ses4.repositories.file;

import com.example.BachEnd_Ses4.model.File.FileLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileLogRepo extends JpaRepository<FileLog, Long> {
}
