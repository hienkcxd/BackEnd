package com.example.BachEnd_Ses4.model.Device;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import com.example.BachEnd_Ses4.model.File.PlayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deviceID;
    private String username;
    private String restoreToken;
    private String deviceName;
    private String firmwareVersion;
    private String appVersion;
    private String activelocation;
    private boolean active;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "schedule_into_device",
            joinColumns = @JoinColumn(name = "device_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    private Collection<FileSchedule> fileSchedulesDevice = new ArrayList<>();
}
