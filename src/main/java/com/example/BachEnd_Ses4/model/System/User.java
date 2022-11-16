package com.example.BachEnd_Ses4.model.System;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(unique = true, nullable = false)
    private String userName;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    //quan hệ 1 nhiều với store
    @OneToMany(mappedBy = "userStore")
    private List<Store> storesOfUser;

    //quan hệ 1 nhiều với userlog
    @OneToMany(mappedBy = "userLog")
    private List<UserLog> logOfUser;
}
