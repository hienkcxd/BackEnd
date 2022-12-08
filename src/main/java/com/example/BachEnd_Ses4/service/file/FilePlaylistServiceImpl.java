package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.PlayList;
import com.example.BachEnd_Ses4.repositories.file.FilePlaylistRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FilePlaylistServiceImpl implements FilePlaylistService {
    @Autowired
    private FilePlaylistRepo filePlaylistRepo;
    @Override
    public void addPlaylist(PlayList playList) {
        filePlaylistRepo.save(playList);
    }

    @Override
    public List<PlayList> findByUsername(String username) {
        return filePlaylistRepo.findByUsername(username);
    }

    @Override
    public List<PlayList> findAll() {
        return filePlaylistRepo.findAll();
    }

    @Override
    public void update(PlayList playList) {
        PlayList playList1Db = detail(playList.getId());
        playList1Db.setId(playList.getId());
        playList1Db.setFileStorages(playList.getFileStorages());
        playList1Db.setPlaylistName(playList.getPlaylistName());
        playList1Db.setPlaylistType(playList.getPlaylistType());
        filePlaylistRepo.save(playList1Db);
    }

    @Override
    public void delete(Long id) {
        filePlaylistRepo.delete(detail(id));
    }

    @Override
    public PlayList detail(Long id) {
        return filePlaylistRepo.findById(id).get();
    }
}
