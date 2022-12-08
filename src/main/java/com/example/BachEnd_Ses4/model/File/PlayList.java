package com.example.BachEnd_Ses4.model.File;

import com.example.BachEnd_Ses4.model.System.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String playlistName;
    private String username;
    private String fileName;
}
