package com.example.BachEnd_Ses4.model.File;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String storeName;
    private Long startTime;
    private Long endTime;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_file")
    private FileStorage fileWithLog;
}
