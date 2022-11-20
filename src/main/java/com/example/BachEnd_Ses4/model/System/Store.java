package com.example.BachEnd_Ses4.model.System;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Store(String storeName) {
        this.storeName=storeName;
    }
}