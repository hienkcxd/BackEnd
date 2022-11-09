package com.example.BachEnd_Ses4.model.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String fileType;
    private String username;
    private Date createDate;
    private String resolution;
    private String times;

    //quan hệ nhiều nhiều với bản playlist
    @ManyToMany(mappedBy = "fileStorages")
    private Collection<PlayList> playLists = new ArrayList<>();
}
