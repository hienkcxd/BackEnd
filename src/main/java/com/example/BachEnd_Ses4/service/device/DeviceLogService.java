package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.DeviceLog;

import java.util.List;

public interface DeviceLogService {
    public List<DeviceLog> findAll();
    public List<DeviceLog> findByUsername(String username);
    public List<DeviceLog> findByDeviceName(String deviceName);
    public List<DeviceLog> findByTime(Long startTime, Long endTime);

    public void addDeviceLog(DeviceLog deviceLog);
}
