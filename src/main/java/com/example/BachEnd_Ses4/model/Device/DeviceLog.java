package com.example.BachEnd_Ses4.model.Device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deviceName;
    private String username;
    private String contentLog;
    private Long createDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_device")
    public Device LogOfDevice;
}
