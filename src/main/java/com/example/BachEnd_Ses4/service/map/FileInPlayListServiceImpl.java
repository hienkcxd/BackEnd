package com.example.BachEnd_Ses4.service.map;

import com.example.BachEnd_Ses4.model.MapData.FileInPlayList;
import com.example.BachEnd_Ses4.repositories.map.FileInPlayListRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FileInPlayListServiceImpl implements FileInPlayListService{
    @Autowired
    private FileInPlayListRepo fileInPlayListRepo;
    @Override
    public List<FileInPlayList> findAll() {
        return fileInPlayListRepo.findAll();
    }

    @Override
    public List<FileInPlayList> findByUsername(String username) {
        return fileInPlayListRepo.findByUsername(username);
    }

    @Override
    public void addFileInPlaylist(FileInPlayList fileInPlayList) {
        fileInPlayListRepo.save(fileInPlayList);
    }

    @Override
    public FileInPlayList detail(Long id) {
        return fileInPlayListRepo.findById(id).get();
    }
}
