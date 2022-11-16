package com.example.BachEnd_Ses4.model.File;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String username;
    private String storeName;
    private Date startTime;
    private Date endTime;
}
