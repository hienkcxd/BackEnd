package com.example.BachEnd_Ses4.model.Device;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deviceName;
    private String description;
}
