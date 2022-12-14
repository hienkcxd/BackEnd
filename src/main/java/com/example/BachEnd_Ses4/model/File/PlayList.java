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
    private String playlistType;
    //quan hệ nhiều nhiều với bảng file storage.
    @ManyToMany(fetch = EAGER)
    @JsonIgnore
    @JoinTable(name = "file_into_playlist",
            joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "file_id"))
    private Collection<FileStorage> fileStorages = new ArrayList<>();

    //quan hệ nhiều nhiều với bảng file schedule
//    @ManyToMany(mappedBy = "playListsSchedule")
//    private Collection<FileSchedule> fileSchedules = new ArrayList<>();

}
