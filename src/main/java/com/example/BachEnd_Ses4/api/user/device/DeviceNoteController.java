package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.Device.DeviceNote;
import com.example.BachEnd_Ses4.service.device.DeviceNoteService;
import com.example.BachEnd_Ses4.service.device.DeviceService;
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
@RequestMapping("/api/user/device-note")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class DeviceNoteController {
    @Autowired
    private DeviceNoteService deviceNoteService;
    @Autowired
    private DeviceService deviceService;

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
    private List<DeviceNote> findByUsername(){
        return  deviceNoteService.findByUsername(getPrincipal());
    }

    @GetMapping("/{deviceName}")
    private List<DeviceNote> findByDevicename(@PathVariable String deviceName){
        Device deviceDb = deviceService.detailByDeviceName(deviceName);
        if(getPrincipal().equals(deviceDb.getUsername())){
            return deviceNoteService.findByDevicename(deviceName);
        }else {
            return null;
        }
    }

    @PostMapping("")
    private void addDeviceNote(@RequestBody DeviceNote deviceNote){
        deviceNoteService.addDeviceNote(deviceNote);
    }

    @PutMapping("")
    private void updDeviceNote(@RequestBody DeviceNote deviceNote){
        if(getPrincipal().equals(deviceNote.getUserName())){
            deviceNoteService.updateDeviceNote(deviceNote);
        }else {
            ResponseEntity.badRequest();
        }
    }
    @DeleteMapping("/{noteId}")
    private void delDeviceNote(@PathVariable String noteId){
        DeviceNote deviceNote = deviceNoteService.detail(Long.valueOf(noteId));
        if(getPrincipal().equals(deviceNote.getUserName())){
            deviceNoteService.deleteDeviceNote(Long.valueOf(noteId));
        }else {
            ResponseEntity.badRequest();
        }
    }
}
