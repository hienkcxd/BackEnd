package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.DeviceNote;

import java.util.List;

public interface NoteDeviceService {
    public List<DeviceNote> findByUsername(String username);
    public List<DeviceNote> findByDevicename(String deviceName);
    public List<DeviceNote> findAll();
    public DeviceNote detail(Long id);
    public void addDeviceNote(DeviceNote deviceNote);
    public void updateDeviceNote(DeviceNote deviceNote);
    public void deleteDeviceNote(Long id);
}
