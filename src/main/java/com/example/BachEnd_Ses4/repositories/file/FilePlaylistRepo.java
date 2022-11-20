package com.example.BachEnd_Ses4.repositories.file;


import com.example.BachEnd_Ses4.model.File.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilePlaylistRepo extends JpaRepository<PlayList, Long> {
}
