package com.example.BachEnd_Ses4.DTO.MapDTO;

import com.example.BachEnd_Ses4.model.File.FileStorage;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DeviceInGroupDTO {
    private Long id;
    private String username;
    private String groupName;
    private String scheduleName;
    private String[] deviceName;
    private String[] playListName;
}
