package com.example.BachEnd_Ses4.model.Device;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import com.example.BachEnd_Ses4.model.File.FileStorage;
import com.example.BachEnd_Ses4.model.File.PlayList;
import com.example.BachEnd_Ses4.model.System.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String deviceID;
    @Column(unique = true, nullable = false)
    private String deviceName;
    private String username;
    private String storeName;
    private String area;
}
