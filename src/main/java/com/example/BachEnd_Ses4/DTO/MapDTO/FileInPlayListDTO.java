package com.example.BachEnd_Ses4.DTO.MapDTO;

import lombok.Data;

import java.util.List;

@Data
public class FileInPlayListDTO {
    private Long id;
    private String username;
    private String playListName;
    private String[] fileName;
}
