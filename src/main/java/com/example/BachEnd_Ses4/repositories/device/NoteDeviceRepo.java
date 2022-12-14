package com.example.BachEnd_Ses4.repositories.device;

import com.example.BachEnd_Ses4.model.Device.DeviceNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteDeviceRepo extends JpaRepository<DeviceNote, Long> {

    @Query(value = "select s from DeviceNote s where s.deviceName = ?1")
    public List<DeviceNote> findByDeviceName(String deviceName);
    @Query(value = "select s from DeviceNote s where s.userName = ?1")
    public List<DeviceNote> findByUserName(String username);
}
