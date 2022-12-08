package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.Device.DeviceLog;
import com.example.BachEnd_Ses4.repositories.device.DeviceLogRepo;
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
public class DeviceLogServiceImpl implements  DeviceLogService{
    @Autowired
    private DeviceLogRepo deviceLogRepo;

    @Override
    public List<DeviceLog> findAll() {
        return deviceLogRepo.findAll();
    }

    @Override
    public List<DeviceLog> findByUsername(String username) {
        return deviceLogRepo.findByUsername(username);
    }

    @Override
    public List<DeviceLog> findByDeviceName(String deviceName) {
        return deviceLogRepo.findByDeviceName(deviceName);
    }

    @Override
    public List<DeviceLog> findByTime(Long startTime, Long endTime) {
        return null;
    }

    @Override
    public void addDeviceLog(DeviceLog deviceLog) {
        deviceLogRepo.save(deviceLog);
    }

}
