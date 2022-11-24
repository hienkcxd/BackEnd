package com.example.BachEnd_Ses4.repositories.device;

import com.example.BachEnd_Ses4.model.Device.DeviceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceLogRepo extends JpaRepository<DeviceLog, Long> {
    @Query(value = "select s from DeviceLog s where s.deviceName = ?1")
    public List<DeviceLog> findByDeviceName(String deviceName);
    public List<DeviceLog> findByUsername(String username);
}
