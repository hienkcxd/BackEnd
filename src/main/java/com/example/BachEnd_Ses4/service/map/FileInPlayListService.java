package com.example.BachEnd_Ses4.service.map;

import com.example.BachEnd_Ses4.model.MapData.FileInPlayList;

import java.util.List;

public interface FileInPlayListService {
    public List<FileInPlayList> findAll();
    public List<FileInPlayList> findByUsername(String username);
    public void addFileInPlaylist(FileInPlayList fileInPlayList);

    public FileInPlayList detail(Long id);
}
