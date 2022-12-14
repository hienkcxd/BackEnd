package com.example.BachEnd_Ses4.api.user.map;

import com.example.BachEnd_Ses4.DTO.MapDTO.DeviceInGroupDTO;
import com.example.BachEnd_Ses4.converter.MapConverter.DeviceInGroupConverter;
import com.example.BachEnd_Ses4.model.MapData.DeviceInGroup;
import com.example.BachEnd_Ses4.service.device.DeviceService;
import com.example.BachEnd_Ses4.service.map.DeviceInGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/device-in-group")
@Slf4j
public class DeviceInGroupController {
    @Autowired
    private DeviceInGroupService deviceInGroupService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceInGroupConverter converter;
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }
    @GetMapping("")
    public List<DeviceInGroupDTO> findByUsername(){
        List<DeviceInGroup> ent = deviceInGroupService.findByUsername(getPrincipal());
        return converter.ListEntityToDTO(ent);
    }
    @GetMapping("/{idGroup}")
    public DeviceInGroupDTO findById(@PathVariable String idGroup){
        DeviceInGroup ent = deviceInGroupService.detail(Long.valueOf(idGroup));
        DeviceInGroupDTO dto = converter.entityToDTO(ent);
        return dto;
    }
    @PostMapping("")
    public DeviceInGroupDTO saveDeviceInGroup(@RequestBody DeviceInGroupDTO dto){
        String[] deviceName = deviceService.deviceInGroup(dto.getGroupName());
        log.info(deviceName.toString());
        dto.setDeviceName(deviceName);
        DeviceInGroup ent = converter.dtoToEntity(dto);
        deviceInGroupService.addDeviceInGroup(ent);
        return dto;
    }
}
