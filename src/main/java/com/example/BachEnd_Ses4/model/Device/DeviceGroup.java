package com.example.BachEnd_Ses4.model.Device;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    private String username;

    @OneToMany(mappedBy = "groupContain")
    private List<Device> deviceinGroup;
}
