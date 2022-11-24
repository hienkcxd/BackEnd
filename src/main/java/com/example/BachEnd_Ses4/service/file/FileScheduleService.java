package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.FileSchedule;

import java.util.List;

public interface FileScheduleService {
    public void addSchedule(FileSchedule fileSchedule);
    public List<FileSchedule> findbyUsername(String username);
    public List<FileSchedule> findAll();
    public void update(FileSchedule fileSchedule);
    public FileSchedule detail(Long id);
    public void delete(Long id);
}
