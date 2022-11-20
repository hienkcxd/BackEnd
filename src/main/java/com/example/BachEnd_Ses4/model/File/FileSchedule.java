package com.example.BachEnd_Ses4.model.File;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.System.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String scheduleName;
    private String userName;
    private String scheduleYpe;
    private Long startSchedule;
    private Long endSchedule;

    //quan hệ nhiều nhiều với bản playlist
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "playlist_into_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private Collection<PlayList> playListsSchedule = new ArrayList<>();

//    @ManyToMany(mappedBy = "fileSchedulesDevice")
//    private Collection<Device> devices = new ArrayList<>();
//
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "id_user")
//    private User userWithFileSchedule;
}
