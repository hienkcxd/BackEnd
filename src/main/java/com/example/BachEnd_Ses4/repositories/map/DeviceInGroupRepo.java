package com.example.BachEnd_Ses4.repositories.map;

import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceInGroupRepo extends JpaRepository<DeviceInGroup, Long> {
    public List<DeviceInGroup> findByUsername(String username);
}
