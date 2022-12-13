package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.DeviceInGroupDTO;
import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;
import com.example.BachEnd_Ses4.service.map.DeviceInGroupService;
import com.example.BachEnd_Ses4.service.map.PlayListInScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceInGroupConverter {
    public DeviceInGroupDTO entityToDTO(DeviceInGroup deviceInGroup){
        DeviceInGroupDTO dto = new DeviceInGroupDTO();
        String[] arrDevice = null;
        String[] arrPlayList = null;
        arrDevice=deviceInGroup.getDeviceName().substring(1, deviceInGroup.getDeviceName().length()-1).split(", ");
        String playListName = deviceInGroup.getPlayListName();
        arrPlayList=playListName.substring(1, playListName.length()-1).split(", ");
        dto.setId(deviceInGroup.getId());
        dto.setUsername(deviceInGroup.getUsername());
        dto.setGroupName(deviceInGroup.getGroupName());
        dto.setScheduleName(deviceInGroup.getScheduleName());
        dto.setDeviceName(arrDevice);
        dto.setPlayListName(arrPlayList);
        return dto;
    }

    public List<DeviceInGroupDTO> ListEntityToDTO(List<DeviceInGroup> deviceInGroupList){
        return deviceInGroupList.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }

    public DeviceInGroup dtoToEntity(DeviceInGroupDTO dto){
        DeviceInGroup ent = new DeviceInGroup();
        String deviceName = new String();
        String playListName = new String();
        String fileName = new String();
        deviceName = Arrays.toString(dto.getDeviceName());
        playListName = Arrays.toString(dto.getPlayListName());
        ent.setId(dto.getId());
        ent.setUsername(dto.getUsername());
        ent.setGroupName(dto.getGroupName());
        ent.setScheduleName(dto.getScheduleName());
        ent.setDeviceName(deviceName);
        ent.setPlayListName(playListName);
        return ent;
    }

    public List<DeviceInGroup> ListDtoToEntity(List<DeviceInGroupDTO> dto){
        return dto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }
}
