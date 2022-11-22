package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.FileLog;
import com.example.BachEnd_Ses4.repositories.file.FileLogRepo;
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
public class FileLogServiceImpl implements FileLogService{
    @Autowired
    private FileLogRepo fileLogRepo;
    @Override
    public void addFileLog(FileLog fileLog) {
        fileLogRepo.save(fileLog);
    }

    @Override
    public List<FileLog> findAll() {
        return fileLogRepo.findAll();
    }

    @Override
    public List<FileLog> findByUsername(String username) {
        return fileLogRepo.findByUsername(username);
    }
}
