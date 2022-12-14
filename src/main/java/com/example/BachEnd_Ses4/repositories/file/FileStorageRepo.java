package com.example.BachEnd_Ses4.repositories.file;

import com.example.BachEnd_Ses4.model.File.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileStorageRepo extends JpaRepository<FileStorage, Long> {
    @Query(value = "select f from FileStorage f where f.userWithFileStorage.userName = ?1")
    public List<FileStorage> findByUsername(String username);
}
