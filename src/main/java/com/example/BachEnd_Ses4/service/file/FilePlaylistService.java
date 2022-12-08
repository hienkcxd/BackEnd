package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.PlayList;

import java.util.List;

public interface FilePlaylistService {
    public void addPlaylist(PlayList playList);
    public List<PlayList> findByUsername(String username);
    public List<PlayList> findAll();
    public void update(PlayList playList);
    public void delete(Long id);
    public PlayList detail(Long id);
}

