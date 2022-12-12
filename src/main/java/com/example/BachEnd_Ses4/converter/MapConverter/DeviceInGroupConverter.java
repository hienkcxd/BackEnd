package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.DeviceInGroupDTO;
import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceInGroupConverter {
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

    public List<DeviceInGroupDTO> ListEntityToDTO(List<DeviceInGroup> deviceInGroupList){
        return deviceInGroupList.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }

    public DeviceInGroup dtoToEntity(DeviceInGroupDTO dto){
        DeviceInGroup ent = new DeviceInGroup();
        String deviceName = new String();
        deviceName = Arrays.toString(dto.getDeviceName());
        ent.setId(dto.getId());
        ent.setUsername(dto.getUsername());
        ent.setGroupName(dto.getGroupName());
        ent.setScheduleName(dto.getScheduleName());
        ent.setDeviceName(deviceName);
        return ent;
    }

    public List<DeviceInGroup> ListDtoToEntity(List<DeviceInGroupDTO> dto){
        return dto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }
}
