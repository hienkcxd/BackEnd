package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.DeviceNote;
import com.example.BachEnd_Ses4.repositories.device.NoteDeviceRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class NoteDeviceServiceImpl implements NoteDeviceService{
    @Autowired
    private NoteDeviceRepo noteDeviceRepo;
    @Override
    public List<DeviceNote> findByUsername(String username) {
        return noteDeviceRepo.findByUserName(username);
    }

    @Override
    public List<DeviceNote> findByDevicename(String deviceName) {
        return noteDeviceRepo.findByDeviceName(deviceName);
    }

    @Override
    public List<DeviceNote> findAll() {
        return noteDeviceRepo.findAll();
    }

    @Override
    public DeviceNote detail(Long id) {
        return noteDeviceRepo.findById(id).get();
    }

    @Override
    public void addDeviceNote(DeviceNote deviceNote) {
        noteDeviceRepo.save(deviceNote);
    }

    @Override
    public void updateDeviceNote(DeviceNote deviceNote) {
        DeviceNote deviceNoteDb = noteDeviceRepo.findById(deviceNote.getId()).get();
        noteDeviceRepo.save(deviceNoteDb);
    }

    @Override
    public void deleteDeviceNote(Long id) {
        noteDeviceRepo.delete(detail(id));
    }
}
