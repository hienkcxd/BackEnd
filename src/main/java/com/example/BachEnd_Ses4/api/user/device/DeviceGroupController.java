package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.model.Device.DeviceGroup;
import com.example.BachEnd_Ses4.service.device.DeviceGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/device-group")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class DeviceGroupController {
    @Autowired
    private DeviceGroupService deviceGroupService;

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
    private List<DeviceGroup> findByUsername(){
        return deviceGroupService.findByUsername(getPrincipal());
    }
    @GetMapping("/{groupId}")
    private DeviceGroup detailGroup(@PathVariable String groupId){
        DeviceGroup deviceGroupDb = deviceGroupService.detailGroup(Long.valueOf(groupId));
        if(getPrincipal().equals(deviceGroupDb.getUsername())){
            return deviceGroupDb;
        }else {
            return (DeviceGroup) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    private void addGroup(@RequestBody DeviceGroup deviceGroup){
        deviceGroupService.addGroup(deviceGroup);
    }

    @PutMapping("")
    private void updateGroup(@RequestBody DeviceGroup deviceGroup){
        DeviceGroup deviceGroupDb = deviceGroupService.detailGroup(deviceGroup.getId());
        if(getPrincipal().equals(deviceGroupDb.getUsername())){
            deviceGroupService.update(deviceGroup);
        }else {
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/{deleteId}")
    private void updateGroup(@PathVariable String deleteId){
        DeviceGroup deviceGroupDb = deviceGroupService.detailGroup(Long.valueOf(deleteId));
        if(getPrincipal().equals(deviceGroupDb.getUsername())){
            deviceGroupService.delete(Long.valueOf(deleteId));
        }else {
            ResponseEntity.badRequest();
        }
    }
}
