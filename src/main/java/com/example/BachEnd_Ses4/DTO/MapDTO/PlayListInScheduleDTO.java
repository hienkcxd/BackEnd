package com.example.BachEnd_Ses4.DTO.MapDTO;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class PlayListInScheduleDTO {
    private Long id;
    private String username;
    private String scheduleName;
    private String[] playListName;
}
