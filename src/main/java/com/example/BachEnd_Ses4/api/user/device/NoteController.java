package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.Device.DeviceNote;
import com.example.BachEnd_Ses4.service.device.DeviceService;
import com.example.BachEnd_Ses4.service.device.NoteDeviceService;
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
public class NoteController {
    @Autowired
    private NoteDeviceService deviceService;


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
    public List<DeviceNote> findByUsername(){
        return deviceService.findByUsername(getPrincipal());
    }

    @GetMapping("/{deviceNoteId}")
    public DeviceNote detailDeviceNote(@PathVariable String deviceNoteId){
        DeviceNote deviceNoteCur = deviceService.detail(Long.valueOf(deviceNoteId));
        if(getPrincipal().equals(deviceNoteCur.getUsername())){
            return deviceNoteCur;
        }else {
            return (DeviceNote) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public void addDevice(@RequestBody DeviceNote DeviceNote){
        deviceService.addDeviceNote(DeviceNote);
    }

    @PutMapping("/update-devicenote")
    public void updDesDevice(@RequestBody DeviceNote DeviceNote){
        DeviceNote deviceCur = deviceService.detail(DeviceNote.getId());
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.updateDeviceNote(DeviceNote);
        }else {
            log.info("device controller - line 65: user khong co quyen update ten va khu vuwjc hoat dong thiet bi nay");
            ResponseEntity.badRequest();
        }
    }


    @DeleteMapping("/{deleteId}")
    public void deleteDevice(@PathVariable String deleteId){
        DeviceNote deviceCur = deviceService.detail(Long.valueOf(deleteId));
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.deleteDeviceNote(Long.valueOf(deleteId));
        }else {
            log.info("device controller - line 95: user khong co quyen xoa device note nay");
            ResponseEntity.badRequest();
        }
    }
}
