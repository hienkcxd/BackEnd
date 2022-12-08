package com.example.BachEnd_Ses4.model.System;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_user")
    private User userWithStore;

    @OneToMany(mappedBy = "storeContain")
    private List<Device> listDeviceinStore;

    public Store(String storeName) {
        this.storeName=storeName;
    }
}
