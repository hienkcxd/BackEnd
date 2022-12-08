package com.example.BachEnd_Ses4.repositories.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepo extends JpaRepository<Device, Long> {
    public List<Device> findByUsername(String username);

    @Query(value = "select s from Device s where s.storeContain.id = ?1")
    public List<Device> findByStore(Long id);

    @Query(value = "select s from Device s where s.deviceName = ?1")
    public Device findByDeviceName(String deviceName);
}
