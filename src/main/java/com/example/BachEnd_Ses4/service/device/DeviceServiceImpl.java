package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.repositories.device.DeviceRepo;
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
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepo deviceRepo;
    @Override
    public void addDevice(Device device) {
        deviceRepo.save(device);
    }

    @Override
    public List<Device> findByUsername(String username) {
        return deviceRepo.findByUsername(username);
    }

    @Override
    public List<Device> findByStore(Long id) {
        return deviceRepo.findByStore(id);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepo.findAll();
    }

    @Override
    public Device detail(Long id) {
        return deviceRepo.findById(id).get();
    }

    @Override
    public Device detailByDeviceName(String deviceName) {
        return deviceRepo.findByDeviceName(deviceName);
    }

    @Override
    public void updateDesDevice(Device device) {
        Device deviceDb = detail(device.getId());
        deviceDb.setDeviceName(device.getDeviceName());
        deviceDb.setActiveLocation(device.getActiveLocation());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void updateActiveDevice(Device device) {
        Device deviceDb = detail(device.getId());
        deviceDb.setActive(device.isActive());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void updateSchedule(Device device) {
        Device deviceDb = detail(device.getId());
        deviceDb.setFileSchedulesDevice(device.getFileSchedulesDevice());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void delete(Long id) {
        deviceRepo.delete(detail(id));
    }
}
