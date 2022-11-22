package com.example.BachEnd_Ses4.repositories.file;

import com.example.BachEnd_Ses4.model.File.FileLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileLogRepo extends JpaRepository<FileLog, Long> {
    public List<FileLog> findByUsername(String username);
}
