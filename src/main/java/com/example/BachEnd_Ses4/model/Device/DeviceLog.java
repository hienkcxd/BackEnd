package com.example.BachEnd_Ses4.model.Device;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deviceName;
    private String contentLog;
    private Date createDate;
}
