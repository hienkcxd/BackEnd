package com.example.BachEnd_Ses4.model.File;

import com.example.BachEnd_Ses4.model.System.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String fileName;
    private String fileType;
    private Long createDate;
    private String resolution;
    private String times;
    private String urlGoogleDrive;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_user")
    private User userWithFileStorage;

}
