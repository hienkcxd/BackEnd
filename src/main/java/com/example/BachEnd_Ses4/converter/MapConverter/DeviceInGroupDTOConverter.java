package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.DeviceInGroupDTO;
import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import org.springframework.stereotype.Component;

@Component
public class DeviceInGroupDTOConverter {
    public DeviceInGroupDTO entityToDTO(DeviceInGroup deviceInGroup){
        DeviceInGroupDTO dto = new DeviceInGroupDTO();
        String[] arr = null;
        arr=deviceInGroup.getDeviceName().substring(1, deviceInGroup.getDeviceName().length()-1).split(", ");
        dto.setId(deviceInGroup.getId());
        dto.setUsername(deviceInGroup.getUsername());
        dto.setGroupName(deviceInGroup.getGroupName());
        dto.setScheduleName(deviceInGroup.getScheduleName());
        dto.setDeviceName(arr);
        return dto;
    }
}
