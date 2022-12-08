package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.DeviceNote;
import com.example.BachEnd_Ses4.repositories.device.DeviceNoteRepo;
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
public class DeviceNoteServiceImpl implements DeviceNoteService {
    @Autowired
    private DeviceNoteRepo deviceNoteRepo;

    @Override
    public List<DeviceNote> findByUsername(String username) {
        return deviceNoteRepo.findByUserName(username);
    }

    @Override
    public List<DeviceNote> findByDevicename(String deviceName) {
        return deviceNoteRepo.findByDeviceName(deviceName);
    }

    @Override
    public List<DeviceNote> findAll() {
        return deviceNoteRepo.findAll();
    }

    @Override
    public DeviceNote detail(Long id) {
        return deviceNoteRepo.findById(id).get();
    }

    @Override
    public void addDeviceNote(DeviceNote deviceNote) {
        deviceNoteRepo.save(deviceNote);
    }

    @Override
    public void updateDeviceNote(DeviceNote deviceNote) {
        DeviceNote deviceNoteDb = deviceNoteRepo.findById(deviceNote.getId()).get();
        deviceNoteDb.setDescription(deviceNote.getDescription());
        deviceNoteRepo.save(deviceNoteDb);
    }

    @Override
    public void deleteDeviceNote(Long id) {
        deviceNoteRepo.delete(detail(id));
    }
}
