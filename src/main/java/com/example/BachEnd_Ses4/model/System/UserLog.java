package com.example.BachEnd_Ses4.model.System;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long createDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_user")
    private User userWithLog;

    public UserLog(String description, long createDate) {
        this.description = description;
        this.createDate = createDate;
    }
}
