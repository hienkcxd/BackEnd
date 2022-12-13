package com.example.BachEnd_Ses4.repositories.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepo extends JpaRepository<Device, Long> {
    public List<Device> findByUsername(String username);

    @Query(value = "select s from Device s where s.groupName= '' and s.username = ?1")
    public List<Device> deviceNoGroup(String username);
    @Query(value = "select s from Device s where s.username = ?1 and s.storeName = ?2")
    public List<Device> findByStore(String username, String storeName);

    @Query(value = "select s from Device s where s.deviceName = ?1")
    public Device findByDeviceName(String deviceName);
}
