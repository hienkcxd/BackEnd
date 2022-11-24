package com.example.BachEnd_Ses4.model.Device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_device")
    public Device NoteOfDevice;
}
