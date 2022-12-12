package com.example.BachEnd_Ses4.DTO.MapDTO;

import lombok.Data;

@Data
public class FileInDeviceDTO {
    private Long id;
    private String username;
    private String deviceName;
    private String groupName;
    private String[] fileName;
}
