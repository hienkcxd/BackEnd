package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.FileInDeviceDTO;
import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import org.springframework.stereotype.Component;

@Component
public class FileInDeviceDTOConverter {
    public FileInDeviceDTO entityToiDTO(DeviceInGroup deviceInGroup){
        FileInDeviceDTO dto = new FileInDeviceDTO();

        return dto;
    }
}
