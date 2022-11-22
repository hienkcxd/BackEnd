package com.example.BachEnd_Ses4.service.file;

import com.example.BachEnd_Ses4.model.File.FileLog;

import java.util.List;

public interface FileLogService {
    public void addFileLog(FileLog fileLog);
    public List<FileLog> findAll();
    public List<FileLog> findByUsername(String username);
}
