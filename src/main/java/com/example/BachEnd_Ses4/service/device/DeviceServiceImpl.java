package com.example.BachEnd_Ses4.service.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.repositories.device.DeviceRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public String[] deviceInGroup(String groupName) {
        List<Device> deviceList = deviceRepo.findByGroupName(groupName);
        List<String> deviceName = new ArrayList<>();
        String[] arr = new String[deviceList.size()];
        for (Device d :deviceList) {
            deviceName.add(d.getDeviceName());
        }
        for (int i = 0; i < deviceName.size(); i++) {
            arr[i] = deviceName.get(i);
        }
        return arr;
    }

    @Override
    public List<Device> findByUsername(String username) {
        return deviceRepo.findByUsername(username);
    }

    @Override
    public List<Device> findByStore(String username, String storeName) {
        return deviceRepo.findByStore(username, storeName);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepo.findAll();
    }

    @Override
    public List<Device> deviceNoGroup(String username) {
        return deviceRepo.deviceNoGroup(username);
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
        deviceRepo.save(deviceDb);
    }

    @Override
    public void addGroupToDevice(Device device) {
        Device deviceDb = detail(device.getId());
        deviceDb.setGroupName(device.getGroupName());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void updateActiveDevice(Device device) {
        Device deviceDb = detail(device.getId());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void updateSchedule(Device device) {
        Device deviceDb = detail(device.getId());
        deviceRepo.save(deviceDb);
    }

    @Override
    public void delete(Long id) {
        deviceRepo.delete(detail(id));
    }
}
