package com.example.BachEnd_Ses4.model.Device;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String groupName;
    private String username;

    @OneToMany(mappedBy = "groupContain")
    private List<Device> deviceinGroup;

    @ManyToMany(fetch = LAZY)
    @JoinTable(name = "schedule_into_device_group",
            joinColumns = @JoinColumn(name = "device_group_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private Collection<FileSchedule> SchedulesIntoDeviceGroup = new ArrayList<>();
}
