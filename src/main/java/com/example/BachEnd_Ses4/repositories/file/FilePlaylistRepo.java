package com.example.BachEnd_Ses4.repositories.file;


import com.example.BachEnd_Ses4.model.File.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilePlaylistRepo extends JpaRepository<PlayList, Long> {
    @Query(value = "select f from PlayList f where f.username = ?1")
    public List<PlayList> findByUsername(String username);
}
