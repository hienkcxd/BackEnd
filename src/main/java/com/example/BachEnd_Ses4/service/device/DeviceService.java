package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.Device;

import java.util.List;

public interface DeviceService {
    public void addDevice(Device device);
    public List<Device> findByUsername(String username);
    public List<Device> findByStore(Long id);
    public List<Device> findAll();
    public Device detail(Long id);
    public Device detailByDeviceName(String deviceName);
    public void updateDesDevice(Device device);
    public void updateActiveDevice(Device device);
    public void updateSchedule(Device device);
    public void delete(Long id);
}
