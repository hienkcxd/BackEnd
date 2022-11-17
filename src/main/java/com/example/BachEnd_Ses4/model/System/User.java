package com.example.BachEnd_Ses4.model.System;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true, nullable = false)
    private String userName;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "userWithArea")
    private List<Area> userAreaList;

    @OneToMany(mappedBy = "userWithStore")
    private List<Store> userStoreList;

    @OneToMany(mappedBy = "userWithLog")
    private List<UserLog> userLogList;

}
