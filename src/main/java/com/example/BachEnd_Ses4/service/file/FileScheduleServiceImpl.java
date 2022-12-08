package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import com.example.BachEnd_Ses4.repositories.file.FileScheduleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FileScheduleServiceImpl implements FileScheduleService {
    @Autowired
    private FileScheduleRepo fileScheduleRepo;

    @Override
    public void addSchedule(FileSchedule fileSchedule) {
        fileScheduleRepo.save(fileSchedule);
    }

    @Override
    public List<FileSchedule> findbyUsername(String username) {
        return fileScheduleRepo.findByUserName(username);
    }

    @Override
    public List<FileSchedule> findAll() {
        return fileScheduleRepo.findAll();
    }

    @Override
    public void update(FileSchedule fileSchedule) {
        FileSchedule fileScheduleDb = fileScheduleRepo.findById(fileSchedule.getId()).get();
        fileScheduleDb.setStartSchedule(fileSchedule.getStartSchedule());
        fileScheduleDb.setEndSchedule(fileSchedule.getEndSchedule());
        fileScheduleDb.setScheduleName(fileSchedule.getScheduleName());
        fileScheduleRepo.save(fileScheduleDb);
    }

    @Override
    public FileSchedule detail(Long id) {
        return fileScheduleRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        fileScheduleRepo.delete(detail(id));
    }
}
