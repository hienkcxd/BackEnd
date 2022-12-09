package com.example.BachEnd_Ses4.repositories.map;

import com.example.BachEnd_Ses4.model.MapData.FileInPlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInPlayListRepo extends JpaRepository<FileInPlayList, Long> {
    public List<FileInPlayList> findByUsername(String username);
}
